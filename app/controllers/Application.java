package controllers;

import javax.inject.Inject;

import play.libs.F.Function0;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import data.SummonerDao;
import data.SummonerDto;

public class Application extends Controller {	
	
	private SummonerDao sumDao;

	@Inject
	public Application(SummonerDao sumDao){
		this.sumDao = sumDao;		
	}
	
    public Promise<Result> index(final String region, final String sumname) {
		return Promise.promise(new Function0<Result>(){

			@Override
			public Result apply() throws Throwable {
				SummonerDto summoner = sumDao.getSummonerByName(region, sumname);
				return ok(index.render("Hi " + summoner.getName() + " (" + summoner.getId() + ")! You are currently level " + summoner.getSummonerLevel()));
			}
			
		});
    }

}
