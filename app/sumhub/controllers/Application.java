package sumhub.controllers;

import java.util.List;

import javax.inject.Inject;

import play.libs.F.Function0;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;
import sumhub.data.StatsDao;
import sumhub.data.SummonerDao;
import sumhub.data.stats.PlayerStatsSummaryDto;
import sumhub.data.stats.PlayerStatsSummaryListDto;
import sumhub.data.summoner.SummonerDto;
import sumhub.services.riot.RiotApi;

public class Application extends Controller {
	
	private SummonerDao sumDao;
	private StatsDao statsDao;
	private RiotApi riotApi;

	@Inject
	public Application(SummonerDao sumDao, StatsDao statsDao, RiotApi riotApi){
		this.sumDao = sumDao;
		this.statsDao = statsDao;
		this.riotApi = riotApi;		
	}
	
	public static Result index(){
		return ok(sumhub.views.html.index.render());
	}
	
    public Promise<Result> summonerProfile(final String region, final String sumname) {
		return Promise.promise(new Function0<Result>(){
			@Override
			public Result apply() throws Throwable {
				SummonerDto summoner = sumDao.getSummonerByName(region, sumname);
				return ok(sumhub.views.html.profile.render(summoner));
			}
		});
    }
    
    public Promise<Result> summonerStats(final String region, final String sumname) {
		return Promise.promise(new Function0<Result>(){
			@Override
			public Result apply() throws Throwable {
				SummonerDto summoner = sumDao.getSummonerByName(region, sumname);
				List<PlayerStatsSummaryDto> stats = statsDao.getSummary(summoner.getId());
				return ok(sumhub.views.html.stats.render(summoner, stats));
			}			
		});
    }
    
    public Promise<Result> updateStatsSummary(final String region, final String sumname) {
		return Promise.promise(new Function0<Result>(){
			@Override
			public Result apply() throws Throwable {
				SummonerDto summoner = sumDao.getSummonerByName(region, sumname);
				PlayerStatsSummaryListDto stats = riotApi.getSummonerStatsSummary(region, summoner.getId()).get(10000);
				statsDao.updateStats(summoner.getId(), stats);
				return ok(sumhub.views.html.index.render());
			}			
		});
    }

}
