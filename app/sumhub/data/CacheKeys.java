package sumhub.data;

public class CacheKeys {
	public static final String SUMMONER = "summoner_";
	public static final String STATS_SUMMARY = "summary_";
	
	public static String summonerNameKey(String region, String name){
		return SUMMONER + region + "_" + name;
	}
	
	public static String summonerIdKey(long id){
		return SUMMONER + id;
	}
	
	public static final String statsSummaryKey(long id){
		return STATS_SUMMARY + id;
	}
}
