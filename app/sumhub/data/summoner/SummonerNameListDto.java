package sumhub.data.summoner;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/13/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerNameListDto {
    private List<SummonerNameDto> summoners = new ArrayList<>();

    public List<SummonerNameDto> getSummoners() {
        return summoners;
    }
}
