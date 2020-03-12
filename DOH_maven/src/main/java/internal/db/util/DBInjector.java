package internal.db.util;

import com.google.inject.Guice;
import com.google.inject.Injector;

import internal.db.dao.frame.DbModule;

public class DBInjector {

	static Injector injector;
	
	static {
		injector = Guice.createInjector(new DbModule());
	}
	
	public static <T> T getInstance(Class<T> clazz) {
		return injector.getInstance(clazz);
	}
	
}
