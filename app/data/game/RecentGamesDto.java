package data.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/10/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentGamesDto {
    private List<GameDto> games = new ArrayList<>();
    private long summonerId;

    public List<GameDto> getGames() {
        return games;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
