package sumhub.data.summoner;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryPageDto {
    private boolean current;
    private String name;
    private List<TalentDto> talents = new ArrayList<>();

    public List<TalentDto> getTalents() {
        return talents;
    }

    public boolean isCurrent() {

        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
