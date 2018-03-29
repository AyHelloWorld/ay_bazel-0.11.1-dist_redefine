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
package com.google.devtools.build.lib.skyframe;

import com.google.common.base.Preconditions;
import com.google.devtools.build.lib.cmdline.PackageIdentifier;
import com.google.devtools.build.lib.concurrent.ThreadSafety.Immutable;
import com.google.devtools.build.lib.concurrent.ThreadSafety.ThreadSafe;
import com.google.devtools.build.lib.packages.BuildFileContainsErrorsException;
import com.google.devtools.build.lib.packages.Package;
import com.google.devtools.build.lib.packages.PackageCodecDependencies;
import com.google.devtools.build.lib.skyframe.serialization.InjectingObjectCodec;
import com.google.devtools.build.lib.skyframe.serialization.autocodec.AutoCodec;
import com.google.devtools.build.skyframe.LegacySkyKey;
import com.google.devtools.build.skyframe.NotComparableSkyValue;
import com.google.devtools.build.skyframe.SkyKey;
import java.util.ArrayList;
import java.util.List;

/** A Skyframe value representing a package. */
@AutoCodec(dependency = PackageCodecDependencies.class)
@Immutable
@ThreadSafe
public class PackageValue implements NotComparableSkyValue {
  public static final InjectingObjectCodec<PackageValue, PackageCodecDependencies> CODEC =
      new PackageValue_AutoCodec();

  private final Package pkg;

  public PackageValue(Package pkg) {
    this.pkg = Preconditions.checkNotNull(pkg);
  }

  /**
   * Returns the package. This package may contain errors, in which case the caller should throw
   * a {@link BuildFileContainsErrorsException} if an error-free package is needed. See also
   * {@link PackageErrorFunction} for the case where encountering a package with errors should shut
   * down the build but the caller can handle packages with errors.
   */
  public Package getPackage() {
    return pkg;
  }

  @Override
  public String toString() {
    return "<PackageValue name=" + pkg.getName() + ">";
  }

  public static SkyKey key(PackageIdentifier pkgIdentifier) {
    Preconditions.checkArgument(!pkgIdentifier.getRepository().isDefault());
    return LegacySkyKey.create(SkyFunctions.PACKAGE, pkgIdentifier);
  }

  public static List<SkyKey> keys(Iterable<PackageIdentifier> pkgIdentifiers) {
    List<SkyKey> keys = new ArrayList<>();
    for (PackageIdentifier pkgIdentifier : pkgIdentifiers) {
      keys.add(key(pkgIdentifier));
    }
    return keys;
  }
}