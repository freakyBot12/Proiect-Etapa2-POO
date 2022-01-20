package input;

import java.util.ArrayList;
import java.util.List;

public final class InitialData {

    private List<Child> children;
    private List<Gift> santaGiftsList;

    public InitialData() {
        children = new ArrayList<>();
        santaGiftsList = new ArrayList<>();
    }

    public InitialData(final List<Child> children, final List<Gift> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(final List<Child> children) {
        this.children = children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
