package factory;

import actions.BudgetCalculator;
import input.Child;

import java.util.*;
import java.util.stream.Collectors;

public class SortSantaChildrenListByNiceScoreCity implements SortSantaChildrenList{
    @Override
    public List<Child> sort(List<Child> children, Map<Integer, List<Double>> niceScoreHistoryMap) {
        children.sort(Comparator.comparingInt(Child::getId));
        Map<String, List<Child>> groupedChildrenByCity = children
                .stream()
                .collect(Collectors.groupingBy(Child::getCity));
        Map<String, List<Child>> groupedChildrenBySortedCities = groupedChildrenByCity
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        Map<String, Double> averageScoresOfCities = new LinkedHashMap<>();
        for (Map.Entry<String, List<Child>> entry : groupedChildrenBySortedCities.entrySet()) {
            double sum = 0;
            for (Child child : entry.getValue()) {
                sum += BudgetCalculator.determineAverageScore(child, niceScoreHistoryMap);
            }
            double averageCityScore = sum / entry.getValue().size();
            averageScoresOfCities.put(entry.getKey(), averageCityScore);
        }
        Map<String, Double> sortedAverageScoresOfCities = averageScoresOfCities
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        List<Child> sortedListOfChildren = new ArrayList<>();
        for (Map.Entry<String, Double> entry : sortedAverageScoresOfCities.entrySet()) {
            for (Child child : children) {
                if (entry.getKey().equals(child.getCity())) {
                    sortedListOfChildren.add(child);
                }
            }
        }
        return sortedListOfChildren;
    }
}
