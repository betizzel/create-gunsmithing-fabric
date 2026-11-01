# Create: Gunsmithing for Fabric 1.20.1

An unofficial, modified Fabric port based on [CreateGunMod](https://github.com/Jetug/CreateGunMod) upstream source revision `be7a671be03b55fb28bd173225d20124a0ff7d75`. Upstream names Jetug, Dayton and melox as authors and credits Alessandra15204 for Italian localisation. This is not an official upstream release.

## License and notices

The upstream root `LICENSE.txt` is GPL version 3 and is preserved here and in the module. Upstream's generated Forge metadata says `All Rights Reserved`; the Fabric descriptor retains that metadata rather than silently changing it. These notices should be read together; no blanket MIT relicensing is claimed. NTGL is a separately licensed dependency; see its own repository and notices. Original author and asset credits remain in the source.

## Build

Clone with the NTGL submodule:

```sh
git clone --recurse-submodules https://github.com/betizzel/create-gunsmithing-fabric.git
cd create-gunsmithing-fabric
export JAVA21_HOME=/path/to/jdk-21
export JAVA17_HOME=/path/to/jdk-17
./build.sh :gunsmithing:build
```

For an existing clone, run `git submodule update --init --recursive` first. Gradle/Loom runs on JDK 21 and compiles for Java 17. The mod JAR is produced in `ports/gunsmithing/build/libs/`. The generated resources are included; dependencies are resolved from the repositories in `build.gradle`.
