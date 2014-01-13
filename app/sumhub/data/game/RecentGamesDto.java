package sumhub.data.game;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
