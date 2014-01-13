package sumhub.data.summoner;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunePageDto {
    private boolean current;
    private long id;
    private String name;
    private List<RuneSlotDto> slots = new ArrayList<>();

    public List<RuneSlotDto> getSlots() {
        return slots;
    }

    public boolean isCurrent() {

        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
