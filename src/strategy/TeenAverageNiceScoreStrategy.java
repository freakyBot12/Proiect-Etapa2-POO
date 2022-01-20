package strategy;

import input.Child;

import java.util.List;
import java.util.Map;

public final class TeenAverageNiceScoreStrategy implements AverageNiceScoreStrategy {
    @Override
    public double execute(final Child child,
                          final Map<Integer, List<Double>> niceScoreHistoryMap) {
        List<Double> scoreHistory = niceScoreHistoryMap.get(child.getId());
        double sumOfScores = 0;
        double sum = 0;
        for (int i = 0; i < scoreHistory.size(); i++) {
            sumOfScores += (scoreHistory.get(i) * (i + 1));
            sum += (i + 1);
        }
        return sumOfScores / sum;
    }
}
