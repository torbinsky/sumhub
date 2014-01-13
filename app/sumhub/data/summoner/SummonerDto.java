package sumhub.data.summoner;

import java.io.Serializable;
import java.util.Date;

import org.jongo.marshall.jackson.oid.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerDto implements Serializable {
	@Id
	private long id;
	private String name;
	private int profileIconId;
	private long revisionDate;
	private long summonerLevel;
	private String region;
	private Date revisionDateStr;

	public SummonerDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("id")
	public void setId0(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public Date getRevisionDateStr() {
		return revisionDateStr == null ? new Date(revisionDate) : revisionDateStr;
	}

	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
		this.revisionDateStr = new Date(revisionDate);
	}

	public long getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDateStr(Date revisionDateStr) {
		this.revisionDateStr = revisionDateStr;
	}

	public long getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
