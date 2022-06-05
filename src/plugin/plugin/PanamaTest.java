package plugin;

import jdk.incubator.foreign.CLinker;

public class PanamaTest {
	public static void main(String[] args) {
		// CLinker.systemCLinker() is a restricted method.
		CLinker.systemCLinker();
	}
}
