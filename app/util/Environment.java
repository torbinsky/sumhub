package util;
import play.api.Mode;
import scala.Enumeration.Value;

import com.typesafe.config.ConfigFactory;


public class Environment {

	public static final String DEV_ENV = "Dev";
	public static final String TEST_ENV = "Test";
	public static final String PROD_ENV = "Prod";

	public static String mode(){
		return ConfigFactory.load().getString("app.environment");
	}
	
	public static boolean isAnyOf(String... modes) {
		for(String mode : modes){
			if(mode.equals(mode())){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isDev() {
		return mode().equalsIgnoreCase(DEV_ENV);
	}

	public static boolean isTest() {
		return mode().equalsIgnoreCase(TEST_ENV);
	}
	
	public static boolean isProd() {
		return mode().equalsIgnoreCase(PROD_ENV);
	}
	
	public static Value playMode(){
		switch(mode()){
		case "Dev":
			return Mode.withName(DEV_ENV);
		case "Test":
			return Mode.withName(TEST_ENV);
		case "Production":
		default:
			return Mode.withName(PROD_ENV);
		}
	}
}
