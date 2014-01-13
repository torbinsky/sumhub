package sumhub.data.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/13/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamIdDto {
    private String fullId;

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }
}
