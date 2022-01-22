package actions;

import strategy.AverageNiceScoreStrategy;
import strategy.BabyAverageNiceScoreStrategy;
import strategy.KidsAverageNiceScoreStrategy;
import strategy.TeenAverageNiceScoreStrategy;
import common.Constants;
import input.Child;
import input.Input;

import java.util.List;
import java.util.Map;

public final class BudgetCalculator {

    private BudgetCalculator() {

    }

    /**
     * functie care calculeaza bugetul alocat unui copil in prima runda
     */
    public static double round0(final Child child, final Input input) {
        double sumOfNiceScores = 0;
        for (Child child1 : input.getInitialData().getChildren()) {
            if (child1.getAge() < Constants.BABY_MAX_AGE) {
                sumOfNiceScores += Constants.AVERAGE_SCORE_FOR_BABY;
            } else {
                sumOfNiceScores += addNiceScoreBonus(child1, child1.getNiceScore());
            }
        }

        double budgetUnit = input.getSantaBudget() / sumOfNiceScores;
        if (child.getAge() < Constants.BABY_MAX_AGE) {
            return ElfActions.calculatedBudgetByElf(child,
                    budgetUnit * Constants.AVERAGE_SCORE_FOR_BABY);
        } else {
            return ElfActions.calculatedBudgetByElf(child,
                    budgetUnit * addNiceScoreBonus(child, child.getNiceScore()));
        }
    }

    /**
     * functie care determina bugetul in functie de varsta copilului
     * (folosita pentru toate rundele in afara de runda 0
     */

    public static double determineBudgetBasedOnAgeAndElfs(final Child child,
                                                          final Map<Integer,
                                                           List<Double>> niceScoreHistoryMap,
                                                          final Input input) {

        double sumOfAllAverageScores = 0;
        for (Child child1 : input.getInitialData().getChildren()) {
            if (child1.getAge() < Constants.BABY_MAX_AGE) {
                AverageNiceScoreStrategy strategy = new BabyAverageNiceScoreStrategy();
                sumOfAllAverageScores += addNiceScoreBonus(child1,
                        strategy.execute(child1, niceScoreHistoryMap));
            }
            if (child1.getAge() >= Constants.BABY_MAX_AGE
                    && child1.getAge() < Constants.KID_MAX_AGE) {
                AverageNiceScoreStrategy strategy = new KidsAverageNiceScoreStrategy();
                sumOfAllAverageScores += addNiceScoreBonus(child1,
                        strategy.execute(child1, niceScoreHistoryMap));
            }
            if (child1.getAge() >= Constants.KID_MAX_AGE
                    && child1.getAge() <= Constants.TEEN_MAX_AGE) {
                AverageNiceScoreStrategy strategy = new TeenAverageNiceScoreStrategy();
                sumOfAllAverageScores += addNiceScoreBonus(child1,
                        strategy.execute(child1, niceScoreHistoryMap));
            }
        }

        double budgetUnit = input.getSantaBudget() / sumOfAllAverageScores;

        if (child.getAge() < Constants.BABY_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new BabyAverageNiceScoreStrategy();
            return ElfActions.calculatedBudgetByElf(child,
                    budgetUnit * addNiceScoreBonus(child,
                            strategy.execute(child, niceScoreHistoryMap)));
        }

        if (child.getAge() < Constants.KID_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new KidsAverageNiceScoreStrategy();
            return ElfActions.calculatedBudgetByElf(child,
                    budgetUnit * addNiceScoreBonus(child,
                            strategy.execute(child, niceScoreHistoryMap)));
        }

        if (child.getAge() <= Constants.TEEN_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new TeenAverageNiceScoreStrategy();
            return ElfActions.calculatedBudgetByElf(child,
                    budgetUnit * addNiceScoreBonus(child,
                            strategy.execute(child, niceScoreHistoryMap)));
        } else {
            return -1;
        }

    }

    /**
     * functie care determina averageScore-ul unui copil
     */
    public static double determineAverageScore(final Child child,
                                               final Map<Integer,
                                                       List<Double>> niceScoreHistoryMap) {
        if (child.getAge() < Constants.BABY_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new BabyAverageNiceScoreStrategy();
            return addNiceScoreBonus(child, strategy.execute(child, niceScoreHistoryMap));
        }
        if (child.getAge() < Constants.KID_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new KidsAverageNiceScoreStrategy();
            return addNiceScoreBonus(child, strategy.execute(child, niceScoreHistoryMap));
        }
        if (child.getAge() <= Constants.TEEN_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new TeenAverageNiceScoreStrategy();
            return addNiceScoreBonus(child, strategy.execute(child, niceScoreHistoryMap));
        } else {
            return -1;
        }
    }

    /**
     * functie care adauga scorul bonus de cumintenie la averageScore-ul fiecarui copil
     */
    public static double addNiceScoreBonus(final Child child, final double averageScore) {
        double newBudget = averageScore;
        newBudget += (newBudget * child.getNiceScoreBonus()) / Constants.NICE_SCORE_BONUS_VARIABLE;
        return Math.min(newBudget, Constants.MAX_NICE_SCORE);
    }

}
