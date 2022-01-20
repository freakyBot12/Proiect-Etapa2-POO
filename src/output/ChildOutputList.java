package output;

import java.util.ArrayList;
import java.util.List;

public final class ChildOutputList {
    private List<ChildOutput> children;

    public ChildOutputList() {
        children = new ArrayList<>();
    }

    public ChildOutputList(final List<ChildOutput> children) {
        this.children = children;
    }

    public List<ChildOutput> getChildren() {
        return children;
    }

    public void setChildren(final List<ChildOutput> children) {
        this.children = children;
    }
}
