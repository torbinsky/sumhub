package data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import play.cache.Cache;
import data.stats.PlayerStatsSummaryDto;
import data.stats.PlayerStatsSummaryListDto;

public class StatsDao {
	private static final String SUMMARY_COL_NAME = "summary";
	
	private Jongo jongo;

	@Inject
	public StatsDao(Jongo jongo){
		this.jongo = jongo;	
	}
	
	public List<PlayerStatsSummaryDto> getSummary(final long id) throws Exception{
		return Cache.getOrElse(CacheKeys.statsSummaryKey(id), new Callable<List<PlayerStatsSummaryDto>>() {

			@Override
			public List<PlayerStatsSummaryDto> call() {
				MongoCollection summaryCol = jongo.getCollection(SUMMARY_COL_NAME);
				ArrayList<PlayerStatsSummaryDto> results = new ArrayList<>();
				for(PlayerStatsSummaryDto summary : summaryCol.find("{summonerId: #}", id).as(PlayerStatsSummaryDto.class)){
					results.add(summary);
				}
				
				return results;
			}
		}, 60);
	}
	
	public void updateStats(long summonerId, PlayerStatsSummaryListDto summaryList){
		for(PlayerStatsSummaryDto summary : summaryList.getPlayerStatSummaries()){
			summary.setSummonerId(summonerId);
			updateSummaryIfNecessary(summary);
		}
	}
	
	private void updateSummaryIfNecessary(PlayerStatsSummaryDto summary){
		MongoCollection summaryCol = jongo.getCollection(SUMMARY_COL_NAME);
		if(summary.getSummonerId() == null){
			throw new IllegalArgumentException("Summoner id cannot be null");
		}
		
		if(summaryCol.count("{summonerId: #, modifyDate: #, playerStatSummaryType: #}", summary.getSummonerId(), summary.getModifyDate(), summary.getPlayerStatSummaryType()) == 0){
			summaryCol.insert(summary);
		}
	}
}
