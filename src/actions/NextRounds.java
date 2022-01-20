package actions;

import input.Child;
import input.ChildUpdate;
import input.Gift;
import input.Input;
import output.ChildOutput;
import output.ChildOutputList;
import output.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class NextRounds {
    private NextRounds() {

    }

    /**
     * simularea celor numberOfYears runde (fara runda 0)
     */
    public static void execute(final Input input, final Output output,
                               final Map<Integer, List<Double>> niceScoreHistoryMap) {

        for (int i = 0; i < input.getNumberOfYears(); i++) {
            RoundUpdates.increaseAge(input);
            RoundUpdates.checkForYoungAdults(input);
            RoundUpdates.updateSantaBudget(input, i);
            for (ChildUpdate childUpdate : input.getAnnualChanges().get(i).getChildrenUpdates()) {
                for (Child child : input.getInitialData().getChildren()) {
                    int updatedChild = UpdateChild.execute(childUpdate, child, niceScoreHistoryMap);
                    if (updatedChild == 1) {
                        break;
                    }
                }
            }
            RoundUpdates.addNewChildren(input, i, niceScoreHistoryMap);
            RoundUpdates.checkForYoungAdults(input);
            RoundUpdates.addNewGifts(input, i);

            ChildOutputList childOutputList = new ChildOutputList();
            for (Child child : input.getInitialData().getChildren()) {
                double allocatedBudget = BudgetCalculator.determineBudgetBasedOnAge(child,
                        niceScoreHistoryMap, input);

                List<Gift> receivedGifts = new ArrayList<>();

                ChosenGift.searchChosenGift(child, input, receivedGifts, allocatedBudget);
                double averageScore = BudgetCalculator.determineAverageScore(child,
                        niceScoreHistoryMap);
                List<Double> niceScoreHistory = niceScoreHistoryMap.get(child.getId());
                ChildOutput childOutput = new ChildOutput(child, averageScore, niceScoreHistory,
                        allocatedBudget, receivedGifts);
                childOutputList.getChildren().add(childOutput);
            }
            output.getAnnualChildren().add(childOutputList);
        }
    }
}
