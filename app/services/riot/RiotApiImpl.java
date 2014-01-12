package services.riot;

import javax.inject.Inject;

import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.WS;
import play.libs.WS.Response;
import play.libs.WS.WSRequestHolder;
import play.mvc.Http.Status;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.ConfigFactory;

import data.stats.PlayerStatsSummaryListDto;
import data.summoner.SummonerDto;

public class RiotApiImpl implements RiotApi {
	private final String apikey;
	@Inject
	RiotApiImpl(){
		apikey = ConfigFactory.load().getString("riot.api_key");
	}
	
	@Override
	public Promise<SummonerDto> getSummonerByName(final String region, String name){
		return getApiObject(new RiotApiUrlBuilder(SummonerApi.SUMMONER_API_PATH)
		.setRegion(region)
		.setSummonerName(name)
		.build()
		).get().map(new Function<Response, SummonerDto>(){
			@Override
			public SummonerDto apply(Response a) throws Throwable {
				checkStatus(a);
				JsonNode json = a.asJson();
				SummonerDto summoner = new ObjectMapper().readValue(json.traverse(), SummonerDto.class);
				summoner.setRegion(region);
				return summoner;				
			}
		});
	}
	
	@Override
	public Promise<PlayerStatsSummaryListDto> getSummonerStatsSummary(final String region, final long summonerId){
		return getApiObject(
				new RiotApiUrlBuilder(StatsApi.STATS_SUMMARY_PATH)
				.setRegion(region)
				.setSummonerId(summonerId)
				.build()
			).get().map(new Function<Response, PlayerStatsSummaryListDto>(){
				@Override
				public PlayerStatsSummaryListDto apply(Response a) throws Throwable {
					checkStatus(a);
					JsonNode json = a.asJson();
					PlayerStatsSummaryListDto summary = new ObjectMapper().readValue(json.traverse(), PlayerStatsSummaryListDto.class);
					return summary;
				}
		});
	}
	
	public static final class RiotApiUrlBuilder{
		private String url;

		public RiotApiUrlBuilder(String url){
			this.url = url;
		}
		
		public RiotApiUrlBuilder setRegion(String region){
			replace("region", region);
			return this;
		}
		
		public RiotApiUrlBuilder setSummonerId(long id){
			replace("summonerId", "" + id);
			return this;
		}
		
		public RiotApiUrlBuilder setSummonerName(String name){
			replace("name", name);
			return this;
		}
		
		public String build(){
			if(url.contains("{")){
				throw new UrlNotFinishedException(url);
			}
			return url;
		}
		
		private void replace(String pathField, String value){
			this.url = url.replaceFirst("\\{" + pathField + "\\}", value);
		}
	}
	public static final class UrlNotFinishedException extends RuntimeException {
		public UrlNotFinishedException(String message) {
			super(message);
		}
	}
	
	private WSRequestHolder getApiObject(String url){
		return WS.url(url).setQueryParameter("api_key", apikey);
	}
	
	private void checkStatus(Response response){
		if (response.getStatus() != Status.OK) {
            switch(response.getStatus()) {
                case Status.BAD_REQUEST: throw new RiotApiBadRequestException();
                case Status.NOT_FOUND: throw new RiotApiNotFoundException();
                case Status.UNAUTHORIZED: throw new RiotApiUnauthorizedException();
                case 429: throw new RiotApiRateLimitException();
                case Status.INTERNAL_SERVER_ERROR: throw new RiotApiInternalErrorException();
                default:
                	throw new RiotApiInternalErrorException();
            }
        }
	}
}
