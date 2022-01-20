package actions;

import common.Constants;
import input.Child;
import input.Gift;
import input.Input;
import output.ChildOutput;
import output.ChildOutputList;
import output.Output;

import java.util.ArrayList;
import java.util.List;

public final class Round0 {
    private Round0() {

    }

    /**
     * simularea primei runde
     */
    public static void execute(final Input input, final Output output) {
        ChildOutputList childOutputList = new ChildOutputList();
        input.getInitialData().getChildren().removeIf(child ->
                child.getAge() > Constants.TEEN_MAX_AGE);
        for (Child child : input.getInitialData().getChildren()) {

            double allocatedBudget = BudgetCalculator.round0(child, input);

            List<Gift> receivedGifts = new ArrayList<>();

            ChosenGift.searchChosenGift(child, input, receivedGifts, allocatedBudget);

            ChildOutput childOutput = new ChildOutput(child, allocatedBudget, receivedGifts);
            if (child.getAge() < Constants.BABY_MAX_AGE) {
                childOutput.setAverageScore(Constants.AVERAGE_SCORE_FOR_BABY);
            }
            childOutputList.getChildren().add(childOutput);
        }

        output.getAnnualChildren().add(childOutputList);
    }
}
