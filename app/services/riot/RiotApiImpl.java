package services.riot;

import javax.inject.Inject;

import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.WS;
import play.libs.WS.Response;
import play.libs.WS.WSRequestHolder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.ConfigFactory;

import data.SummonerDto;

public class RiotApiImpl implements RiotApi {
	private final String apikey;
	@Inject
	RiotApiImpl(){
		apikey = ConfigFactory.load().getString("riot.api_key");
	}
	
	@Override
	public Promise<SummonerDto> getSummonerByName(final String region, String name){
		return getApiObject(region, RiotApi.SUMMONER_API_PATH + "by-name/" + name).get().map(new Function<Response, SummonerDto>(){
			@Override
			public SummonerDto apply(Response a) throws Throwable {
				JsonNode json = a.asJson();
				SummonerDto summoner = new ObjectMapper().readValue(json.traverse(), SummonerDto.class);
				summoner.setRegion(region);
				return summoner;				
			}			
		});
	}
	
	private String getApiUrl(String region, String objPath){
		return RiotApi.LOL_API_BASE_URL + region + "/" + objPath;
	}
	
	private WSRequestHolder getApiObject(String region, String objPath){
		return WS.url(getApiUrl(region, objPath)).setQueryParameter("api_key", apikey);
	}
}
