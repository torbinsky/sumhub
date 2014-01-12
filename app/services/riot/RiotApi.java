package services.riot;

import play.libs.F.Promise;
import data.SummonerDto;

public interface RiotApi {
	public static final String LOL_API_BASE_URL = "https://prod.api.pvp.net/api/lol/";
	public static final String SUMMONER_API_PATH = "v1.2/summoner/";
	
	Promise<SummonerDto> getSummonerByName(String region, String name);
}
