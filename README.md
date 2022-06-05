# PanamaRuntimeModule
Example loading a module at runtime

This is a small [reproducer](https://en.wikipedia.org/wiki/Minimal_reproducible_example) for trying to use restricted foreign methods from a module not in the boot layer.

Compile with 

    javac --release 18 -d bin --module launcher,plugin --module-source-path src
	
Run with

    java --enable-native-access=plugin -p bin/launcher -m launcher/launcher.Launcher
	
For convinience `build.bat`/`build.sh` will run `javac`, and `run.bat`/`run.sh` will run `java`.