package sumhub.data.champion;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/10/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionListDto {
    private List<ChampionDto> champions = new ArrayList<>();

    public List<ChampionDto> getChampions() {
        return champions;
    }
}
