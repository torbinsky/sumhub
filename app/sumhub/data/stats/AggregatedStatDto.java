package sumhub.data.stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AggregatedStatDto {
	public Integer averageAssists;
    public Integer averageChampionsKilled;
    public Integer averageCombatPlayerScore;
    public Integer averageNodeCapture;
    public Integer averageNodeCaptureAssist;
    public Integer averageNodeNeutralize;
    public Integer averageNodeNeutralizeAssist;
    public Integer averageNumDeaths;
    public Integer averageObjectivePlayerScore;
    public Integer averageTeamObjective;
    public Integer averageTotalPlayerScore;
    public Integer botGamesPlayed;
    public Integer killingSpree;
    public Integer maxAssists;
    public Integer maxChampionsKilled;
    public Integer maxCombatPlayerScore;
    public Integer maxLargestCriticalStrike;
    public Integer maxLargestKillingSpree;
    public Integer maxNodeCapture;
    public Integer maxNodeCaptureAssist;
    public Integer maxNodeNeutralize;
    public Integer maxNodeNeutralizeAssist;
    public Integer maxObjectivePlayerScore;
    public Integer maxTeamObjective;
    public Integer maxTimePlayed;
    public Integer maxTimeSpentLiving;
    public Integer maxTotalPlayerScore;
    public Integer mostChampionKillsPerSession;
    public Integer mostSpellsCast;
    public Integer normalGamesPlayed;
    public Integer rankedPremadeGamesPlayed;
    public Integer rankedSoloGamesPlayed;
    public Integer totalAssists;
    public Integer totalChampionKills;
    public Integer totalDamageDealt;
    public Integer totalDamageTaken;
    public Integer totalDoubleKills;
    public Integer totalFirstBlood;
    public Integer totalGoldEarned;
    public Integer totalHeal;
    public Integer totalMagicDamageDealt;
    public Integer totalMinionKills;
    public Integer totalNeutralMinionsKilled;
    public Integer totalNodeCapture;
    public Integer totalNodeNeutralize;
    public Integer totalPentaKills;
    public Integer totalPhysicalDamageDealt;
    public Integer totalQuadraKills;
    public Integer totalSessionsLost;
    public Integer totalSessionsPlayed;
    public Integer totalSessionsWon;
    public Integer totalTripleKills;
    public Integer totalTurretsKilled;
    public Integer totalUnrealKills;
}
