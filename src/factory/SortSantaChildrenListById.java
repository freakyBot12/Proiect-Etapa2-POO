package factory;

import input.Child;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class SortSantaChildrenListById implements SortSantaChildrenList {
    @Override
    public List<Child> sort(final List<Child> children,
                            final Map<Integer, List<Double>> niceScoreHistoryMap) {
        children.sort(Comparator.comparingInt(Child::getId));
        return children;
    }
}
