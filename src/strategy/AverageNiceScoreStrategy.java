package strategy;

import input.Child;

import java.util.List;
import java.util.Map;

public interface AverageNiceScoreStrategy {
    /**
     * functia care va executa strategiile
     */
    double execute(Child child, Map<Integer, List<Double>> niceScoreHistoryMap);
}
