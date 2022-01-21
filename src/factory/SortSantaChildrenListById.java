package factory;

import input.Child;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortSantaChildrenListById implements SortSantaChildrenList{
    @Override
    public List<Child> sort(List<Child> children, Map<Integer, List<Double>> niceScoreHistoryMap) {
        children.sort(Comparator.comparingInt(Child::getId));
        return children;
    }
}
