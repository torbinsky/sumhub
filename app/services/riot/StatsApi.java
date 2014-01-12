package services.riot;

import play.libs.F.Promise;
import data.stats.PlayerStatsSummaryListDto;

public interface StatsApi {
    public static final String STATS_SUMMARY_PATH = RiotApi.LOL_API_BASE_URL + "{region}/v1.2/stats/by-summoner/{summonerId}/summary";
    public static final String STATS_RANKED_PATH = RiotApi.LOL_API_BASE_URL + "{region}/v1.2/stats/by-summoner/{summonerId}/ranked";
    
    Promise<PlayerStatsSummaryListDto> getSummonerStatsSummary(final String region, long summonerId);
}
