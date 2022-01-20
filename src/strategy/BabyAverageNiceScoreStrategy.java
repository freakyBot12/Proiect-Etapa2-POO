package strategy;

import common.Constants;
import input.Child;

import java.util.List;
import java.util.Map;

public final class BabyAverageNiceScoreStrategy implements AverageNiceScoreStrategy {
    @Override
    public double execute(final Child child,
                          final Map<Integer, List<Double>> niceScoreHistoryMap) {
        return Constants.AVERAGE_SCORE_FOR_BABY;
    }
}
