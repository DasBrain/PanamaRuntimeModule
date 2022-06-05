package launcher;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class Launcher {
	public static void main(String[] args) throws Throwable {
		var mf = ModuleFinder.of(Path.of("bin", "plugin"));
		var cf = Configuration.resolve(ModuleFinder.of(), List.of(ModuleLayer.boot().configuration()), mf,
				Set.of("plugin"));
		var controller = ModuleLayer.defineModulesWithOneLoader(cf, List.of(ModuleLayer.boot()),
				ClassLoader.getSystemClassLoader());
		var extraModule = controller.layer().findModule("plugin").orElseThrow();
		controller.addOpens(extraModule, "plugin", Launcher.class.getModule());
		Class<?> mainClass = Class.forName(extraModule, "plugin.PanamaTest");
		Method m = mainClass.getMethod("main", String[].class);
		m.setAccessible(true);
		try {
			m.invoke(null, new Object[] {args});
		} catch (InvocationTargetException ite) {
			throw ite.getCause();
		}
	}
}
