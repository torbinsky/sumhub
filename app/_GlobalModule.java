import services.db._DbModule;
import services.riot._RiotModule;

import com.google.inject.AbstractModule;


public class _GlobalModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new _DbModule());
		install(new _RiotModule());
	}

}
