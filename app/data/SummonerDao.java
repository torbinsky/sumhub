package data;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import play.cache.Cache;
import services.riot.RiotApi;

public class SummonerDao {
	private static final String SUMMONER_COL_NAME = "summoner";
	
	private Jongo jongo;
	private RiotApi api;

	@Inject
	public SummonerDao(Jongo jongo, RiotApi api){
		this.jongo = jongo;
		this.api = api;		
	}
	
	public SummonerDto getSummonerByName(final String region, final String name) throws Exception{
		return Cache.getOrElse(CacheKeys.summonerNameKey(region, name), new Callable<SummonerDto>() {

			@Override
			public SummonerDto call() {
				MongoCollection summonerCol = jongo.getCollection(SUMMONER_COL_NAME);
				SummonerDto summoner = summonerCol.findOne("{name: #, region: #}", name, region).as(SummonerDto.class);
				if(summoner == null){
					// Lookup in the API
					summoner = api.getSummonerByName(region, name).get(10000);
					// Save in the database
					summonerCol.save(summoner);
				}
				return summoner;
			}
		}, 60);
	}
	
	public SummonerDto getSummonerById(final long id) throws Exception{
		return Cache.getOrElse(CacheKeys.summonerIdKey(id), new Callable<SummonerDto>() {

			@Override
			public SummonerDto call() {
				SummonerDto summoner = jongo.getCollection(SUMMONER_COL_NAME).findOne("{id: #}", id).as(SummonerDto.class);
				return summoner;
			}
		}, 60);
	}
}
