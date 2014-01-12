package services.riot;


public interface RiotApi extends ChampionsApi, GameApi, LeagueApi, StatsApi, TeamApi, SummonerApi {
	public static final String LOL_API_BASE_URL = "https://prod.api.pvp.net/api/lol/";
	
	// API Exceptions
	public static class RiotApiException extends RuntimeException {}
	public static final class RiotApiErrorException extends RiotApiException {}
	public static final class RiotApiNotFoundException extends RiotApiException {}
	public static final class RiotApiUnauthorizedException extends RiotApiException {}
	public static final class RiotApiBadRequestException extends RiotApiException {}
	public static final class RiotApiRateLimitException extends RiotApiException {}
	public static final class RiotApiInternalErrorException extends RiotApiException {}

}
