package sumhub.data.summoner;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryPagesDto {
    private List<MasteryPageDto> pages = new ArrayList<>();
    private long summonerId;

    public List<MasteryPageDto> getPages() {
        return pages;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
