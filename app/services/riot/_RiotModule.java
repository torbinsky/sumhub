package services.riot;

import com.google.inject.AbstractModule;

public class _RiotModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RiotApi.class).to(RiotApiImpl.class);
	}

}
