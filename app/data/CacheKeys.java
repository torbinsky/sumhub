package data;

public class CacheKeys {
	public static final String SUMMONER = "summoner_";
	public static String summonerNameKey(String region, String name){
		return SUMMONER + region + "_" + name;
	}
	
	public static String summonerIdKey(long id){
		return SUMMONER + id;
	}
}