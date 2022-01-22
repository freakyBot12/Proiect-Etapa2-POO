package input;

import java.util.ArrayList;
import java.util.List;

public final class ChildUpdate {

    private int id;
    private Double niceScore;
    private List<String> giftsPreferences;
    private String elf;

    public ChildUpdate() {
        giftsPreferences = new ArrayList<>();
    }

    public ChildUpdate(final int id,
                       final Double newNiceScore,
                       final List<String> giftsPreferences,
                       final String elf) {
        this.id = id;
        this.niceScore = newNiceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public String getElf() {
        return elf;
    }

    public void setElf(final String elf) {
        this.elf = elf;
    }
}
