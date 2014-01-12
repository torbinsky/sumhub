package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.ConfigFactory;

import play.*;
import play.cache.Cache;
import play.cache.Cached;
import play.libs.F.*;
import play.libs.WS;
import play.libs.WS.Response;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	public static final String LOL_API_BASE_URL = "https://prod.api.pvp.net/api/lol/na/";
    public static Promise<Result> index(final String sumname) {
    	final String apikey = ConfigFactory.load().getString("riot.api_key");
		return WS.url(LOL_API_BASE_URL + "v1.2/summoner/by-name/" + sumname).setQueryParameter("api_key", apikey).get().map(new Function<WS.Response, Result>() {

			@Override
			public Result apply(Response a) throws Throwable {
				JsonNode resp = a.asJson();
				String name = resp.get("name").asText();
				String level = resp.get("summonerLevel").asText();
				long id = resp.get("id").asLong();
				return ok(index.render("Hi " + name + " (" + id + ")! You are currently level " + level));
			}
		});
    }

}
