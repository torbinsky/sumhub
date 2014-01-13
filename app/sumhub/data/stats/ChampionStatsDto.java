package sumhub.data.stats;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionStatsDto {
    private int id;
    private String name;
    private List<ChampionStatDto> stats = new ArrayList<>();

    public List<ChampionStatDto> getStats() {
        return stats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
