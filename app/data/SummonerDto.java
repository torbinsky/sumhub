package data;

import java.io.Serializable;
import java.util.Date;

import org.jongo.marshall.jackson.oid.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SummonerDto implements Serializable {
	@Id
	private long id;
	private String name;
	private int profileIconId;
	private Date revisionDate;
	private long summonerLevel;
	private String region;
	
	public SummonerDto() {
		super();
	}

	public SummonerDto(String region, long id, String name, int profileIconId, Date revisionDate, long summonerLevel) {
		super();
		this.region = region;
		this.id = id;
		this.name = name;
		this.profileIconId = profileIconId;		
		this.revisionDate = revisionDate;
		this.summonerLevel = summonerLevel;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@JsonProperty("id")
	public void setId0(long id){
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
	public Date getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
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
