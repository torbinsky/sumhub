package sumhub.data.league;

import java.util.ArrayList;
import java.util.List;

import sumhub.util.Queue;
import sumhub.util.Tier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueDto {
    private List<LeagueItemDto> entries = new ArrayList<>();
    private String name;
    private Queue queue;
    private Tier tier;
    private long timestamp;

    public List<LeagueItemDto> getEntries() {
        return entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
