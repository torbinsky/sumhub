package sumhub.data.stats;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatsSummaryListDto {
    private List<PlayerStatsSummaryDto> playerStatSummaries = new ArrayList<>();
    private long summonerId;

    public List<PlayerStatsSummaryDto> getPlayerStatSummaries() {
        return playerStatSummaries;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
