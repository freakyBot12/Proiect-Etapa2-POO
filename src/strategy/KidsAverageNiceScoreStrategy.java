package strategy;

import input.Child;

import java.util.List;
import java.util.Map;

public final class KidsAverageNiceScoreStrategy implements AverageNiceScoreStrategy {
    @Override
    public double execute(final Child child,
                          final Map<Integer, List<Double>> niceScoreHistoryMap) {
        List<Double> scoreHistory = niceScoreHistoryMap.get(child.getId());
        double sumOfScores = 0;
        for (Double score : scoreHistory) {
            sumOfScores += score;
        }
        return sumOfScores / scoreHistory.size();
    }
}
