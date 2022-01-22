package actions;

import factory.SortFactory;
import factory.SortSantaChildrenList;
import input.Child;
import input.ChildUpdate;
import input.Gift;
import input.Input;
import output.ChildOutput;
import output.ChildOutputList;
import output.Output;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
                    int updatedChild = UpdateChild.execute(childUpdate,
                            child,
                            niceScoreHistoryMap);
                    if (updatedChild == 1) {
                        break;
                    }
                }
            }
            RoundUpdates.addNewChildren(input, i, niceScoreHistoryMap);
            RoundUpdates.checkForYoungAdults(input);
            RoundUpdates.addNewGifts(input, i);

            List<Child> newChildList = new ArrayList<>(input.getInitialData().getChildren());
            SortFactory sortFactory = new SortFactory();
            String strategy = input.getAnnualChanges().get(i).getStrategy();
            SortSantaChildrenList sortType = sortFactory.getSortType(strategy);
            List<Child> sortedChildList = sortType.sort(newChildList, niceScoreHistoryMap);

            Map<Integer, List<Gift>> mapWithReceivedGifts = new LinkedHashMap<>();

            for (Child child : sortedChildList) {
                double allocatedBudget = BudgetCalculator.determineBudgetBasedOnAge(child,
                        niceScoreHistoryMap, input);

                List<Gift> receivedGifts = new ArrayList<>();

                ChosenGift.searchChosenGift(child, input, receivedGifts, allocatedBudget);
                mapWithReceivedGifts.put(child.getId(), receivedGifts);
            }

            ChildOutputList childOutputList = new ChildOutputList();
            for (Child child : input.getInitialData().getChildren()) {
                double allocatedBudget = BudgetCalculator.determineBudgetBasedOnAge(child,
                        niceScoreHistoryMap, input);

                List<Gift> receivedGifts = new ArrayList<>(mapWithReceivedGifts.
                        get(child.getId()));
                if (receivedGifts.size() == 0 && child.getElf().equals("yellow")) {
                    ChosenGiftByYellowElf.searchChosenGiftByYellowElf(child,
                            input,
                            receivedGifts);
                }
                double averageScore = BudgetCalculator.determineAverageScore(child,
                        niceScoreHistoryMap);
                List<Double> niceScoreHistory = niceScoreHistoryMap.get(child.getId());

                ChildOutput childOutput = new ChildOutput.Builder(child)
                        .setAverageScore(averageScore)
                        .setNiceScoreHistory(new ArrayList<>(niceScoreHistory))
                        .setAssignedBudget(allocatedBudget)
                        .setReceivedGifts(receivedGifts)
                        .build();
                childOutputList.getChildren().add(childOutput);
            }
            output.getAnnualChildren().add(childOutputList);
        }
    }
}
