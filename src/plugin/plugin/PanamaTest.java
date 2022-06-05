package plugin;

import java.lang.foreign.Linker;

public class PanamaTest {
	public static void main(String[] args) {
		// Linker.nativeLinker() is a restricted method.
		Linker.nativeLinker();
	}
}
