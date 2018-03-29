// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.rules.python;

import com.google.common.collect.ImmutableSet;
import com.google.devtools.build.lib.actions.Artifact;
import com.google.devtools.build.lib.actions.ArtifactRoot;
import com.google.devtools.build.lib.analysis.FilesToRunProvider;
import com.google.devtools.build.lib.analysis.RuleContext;
import com.google.devtools.build.lib.analysis.Runfiles;
import com.google.devtools.build.lib.analysis.actions.CustomCommandLine;
import com.google.devtools.build.lib.analysis.actions.SpawnAction;
import com.google.devtools.build.lib.analysis.configuredtargets.RuleConfiguredTarget;
import com.google.devtools.build.lib.util.FileType;
import com.google.devtools.build.lib.vfs.PathFragment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Various utility methods for Python support.
 */
public final class PythonUtils {
  public static final PathFragment INIT_PY = PathFragment.create("__init__.py");
  public static final PathFragment INIT_PYC = PathFragment.create("__init__.pyc");

  private static final FileType REQUIRES_INIT_PY = FileType.of(".py", ".so", ".pyc");

  public static final Runfiles.EmptyFilesSupplier GET_INIT_PY_FILES =
      new Runfiles.EmptyFilesSupplier() {
    @Override
    public Iterable<PathFragment> getExtraPaths(Set<PathFragment> manifestPaths) {
      return getInitPyFiles(manifestPaths);
    }
  };

  private PythonUtils() {
    // This is a utility class, not to be instantiated
  }

  /**
   * Returns the set of empty __init__.py(c) files to be added to a given set of files to allow
   * the Python runtime to find the <code>.py</code> and <code>.so</code> files present in the
   * tree.
   */
  public static Set<PathFragment> getInitPyFiles(Set<PathFragment> manifestFiles) {
    Set<PathFragment> result = new HashSet<>();

    for (PathFragment source : manifestFiles) {
      // If we have a python or .so file at this level...
      if (REQUIRES_INIT_PY.matches(source)) {
        // ...then record that we need an __init__.py in this directory...
        while (source.segmentCount() > 1) {
          source = source.getParentDirectory();
          PathFragment initpy = source.getRelative(INIT_PY);
          PathFragment initpyc = source.getRelative(INIT_PYC);

          if (!manifestFiles.contains(initpy) && !manifestFiles.contains(initpyc)) {
            result.add(initpy);
          }
        }
      }
    }

    return ImmutableSet.copyOf(result);
  }

  /**
   * Get the artifact generated by the 2to3 action. The artifact is in a python3
   * subdirectory to avoid conflicts (eg. when the input file is generated).
   */
  private static Artifact get2to3OutputArtifact(RuleContext ruleContext, Artifact input) {
    ArtifactRoot root =
        ruleContext.getConfiguration().getGenfilesDirectory(ruleContext.getRule().getRepository());
    PathFragment path = PathFragment.create("python3").getRelative(input.getRootRelativePath());
    return ruleContext.getShareableArtifact(path, root);
  }

  /**
   * Create an action for each Python 2 file to convert to Python 3
   */
  public static Map<PathFragment, Artifact> generate2to3Actions(RuleContext ruleContext,
      Iterable<Artifact> inputs) {
    // This creates many actions, but this is fine. Creating one action per library leads
    // to some problems (when the same file is generated by two different actions), with
    // little benefits and negligible memory improvement.

    Map<PathFragment, Artifact> symlinks = new HashMap<>();
    for (Artifact input : inputs) {
      Artifact output = generate2to3Action(ruleContext, input);
      symlinks.put(input.getRootRelativePath(), output);
    }
    return symlinks;
  }

  private static Artifact generate2to3Action(RuleContext ruleContext, Artifact input) {
    FilesToRunProvider py2to3converter =
        ruleContext.getExecutablePrerequisite("$python2to3", RuleConfiguredTarget.Mode.HOST);
    Artifact output = get2to3OutputArtifact(ruleContext, input);
    CustomCommandLine.Builder commandLine =
        CustomCommandLine.builder()
            .add("--no-diffs")
            .add("--nobackups")
            .add("--write")
            .addPath("--output-dir", output.getExecPath().getParentDirectory())
            .add("--write-unchanged-files")
            .addExecPath(input);

    ruleContext.registerAction(
        new SpawnAction.Builder()
            .addInput(input)
            .addOutput(output)
            .setExecutable(py2to3converter)
            .setProgressMessage("Converting to Python 3: %s", input.prettyPrint())
            .setMnemonic("2to3")
            .addCommandLine(commandLine.build())
            .build(ruleContext));
    return output;
  }
}