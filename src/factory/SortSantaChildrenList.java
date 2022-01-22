package factory;

import input.Child;

import java.util.List;
import java.util.Map;

public interface SortSantaChildrenList {
    /** functie care sorteaza (temporar) lista de copii pentru a le acorda cadouri in
     * functie de strategia de asignare din input
     */
    List<Child> sort(List<Child> children, Map<Integer, List<Double>> niceScoreHistoryMap);
}
