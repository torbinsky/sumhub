package sumhub.services.riot;

import play.libs.F.Promise;
import sumhub.data.summoner.SummonerDto;

public interface SummonerApi {
	public static final String SUMMONER_API_PATH = RiotApi.LOL_API_BASE_URL + "{region}/v1.2/summoner/by-name/{name}";	
	Promise<SummonerDto> getSummonerByName(String region, String name);
}
