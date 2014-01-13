package sumhub.data.team;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/13/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RosterDto {
    private List<TeamMemberInfoDto> memberList = new ArrayList<>();
    private long ownerId;

    public List<TeamMemberInfoDto> getMemberList() {
        return memberList;
    }

    public long getOwnerId() {

        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
