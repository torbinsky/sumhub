package data.stats;

import java.util.Date;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatsSummaryDto {
	@Id
	ObjectId id;
    private AggregatedStatDto aggregatedStats;
    private int losses;
    private long modifyDate;
    private Date modifyDateStr;
    private String playerStatSummaryType;
    private int wins;
    private Long summonerId;

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
        this.modifyDateStr = new Date(modifyDate);
    }

    public Date getModifyDateStr() {
        return modifyDateStr == null ? new Date(modifyDate) : modifyDateStr;
    }

    public void setModifyDateStr(Date modifyDateStr) {
        this.modifyDateStr = modifyDateStr;
    }

    public String getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    public void setPlayerStatSummaryType(String playerStatSummaryType) {
        this.playerStatSummaryType = playerStatSummaryType;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

	public Long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(Long summonerId) {
		this.summonerId = summonerId;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public AggregatedStatDto getAggregatedStats() {
		return aggregatedStats;
	}

	public void setAggregatedStats(AggregatedStatDto aggregatedStats) {
		this.aggregatedStats = aggregatedStats;
	}
	
}
