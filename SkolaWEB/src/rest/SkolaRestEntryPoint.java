package rest;

import java.util.HashSet;
import java.util.Set;

import javax.imageio.spi.RegisterableService;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/Skola")
public class SkolaRestEntryPoint extends Application {


	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> classes = new HashSet<>();
		classes.add(AuthenticationFilter.class);
		return classes;
	}
	
	
}
