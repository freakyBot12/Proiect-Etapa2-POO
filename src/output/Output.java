package output;

import java.util.ArrayList;
import java.util.List;

public final class Output {
    private List<ChildOutputList> annualChildren;
    private static Output instance = null;

    private Output() {
        annualChildren = new ArrayList<>();
    }

    /**
     * clasa Output este de tip Singleton
     */
    public static Output getInstance() {
        if (instance == null) {
            instance = new Output();
        }
        return instance;
    }

    public List<ChildOutputList> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final List<ChildOutputList> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
