import sumhub.services.db._DbModule;
import sumhub.services.riot._RiotModule;

import com.google.inject.AbstractModule;


public class _GlobalModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new _DbModule());
		install(new _RiotModule());
	}

}
