package factory;

import actions.BudgetCalculator;
import input.Child;

import java.util.*;
import java.util.stream.Collectors;

public class SortSantaChildrenListByNiceScore implements SortSantaChildrenList{
    @Override
    public List<Child> sort(List<Child> children, Map<Integer, List<Double>> niceScoreHistoryMap) {
        children.sort(Comparator.comparingInt(Child::getId));
        Map<Child, Double> map = new LinkedHashMap<>();
        for (Child child : children) {
            map.put(child,
                    BudgetCalculator.determineAverageScore(child, niceScoreHistoryMap));
        }
        Map<Child, Double> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        return new ArrayList<>(sortedMap.keySet());
    }
}
