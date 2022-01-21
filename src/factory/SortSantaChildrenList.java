package factory;

import input.Child;

import java.util.List;
import java.util.Map;

public interface SortSantaChildrenList {
    List<Child> sort(List<Child> children, Map<Integer, List<Double>> niceScoreHistoryMap);
}
