package sumhub.data.summoner;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunePagesDto {
    private Set<RunePageDto> pages = new HashSet<>();
    private long summonerId;

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public Set<RunePageDto> getPages() {

        return pages;
    }
}
