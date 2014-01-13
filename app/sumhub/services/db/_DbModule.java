package sumhub.services.db;

import java.net.UnknownHostException;

import javax.inject.Singleton;
import javax.net.ssl.SSLSocketFactory;

import org.jongo.Jongo;

import play.Logger;
import play.Logger.ALogger;
import sumhub.util.Environment;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class _DbModule extends AbstractModule {
	ALogger logger = Logger.of(_DbModule.class);
	
	@Override
	protected void configure() {
		
	}

	
	@Provides @Singleton
	Mongo provideMongo() throws UnknownHostException{
		Config config = ConfigFactory.load();
		String dbHost = config.getString("mongo.host");
		int dbPort = config.getInt("mongo.db.port");
		logger.info("Connecting to db host[{}] port[{}]", dbHost, dbPort);		
		
		// Setup connection options
		MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();			
		if(config.getBoolean("mongo.db.usessl")){
			logger.info("Mongo SSL enabled.");
			optionsBuilder = optionsBuilder.socketFactory(SSLSocketFactory.getDefault());
		}            
        MongoClientOptions o = optionsBuilder.build();
        
		logger.info("Mongo connections per host set to[{}]", o.getConnectionsPerHost());
		MongoClient mongo = new MongoClient(new ServerAddress(dbHost, dbPort), o);
		
		logger.info("Finished initializing MongoClient!");		
		return mongo;
	}	
	
	@Provides @Singleton
	Jongo provideJongo(Mongo mongo){
		Config config = ConfigFactory.load();
		String dbName = config.getString("mongo.db.name");		
		DB db = mongo.getDB(dbName);
		if(Environment.isProd()){
			String user = config.getString("mongo.db.user");
			String password = config.getString("mongo.db.pass");
			db.authenticate(user, password.toCharArray());
		}
		Jongo jongo = new Jongo(db);
		return jongo;
	}
}
