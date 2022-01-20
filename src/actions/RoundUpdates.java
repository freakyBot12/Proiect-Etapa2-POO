package actions;

import common.Constants;
import input.Child;
import input.Gift;
import input.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class RoundUpdates {
    private RoundUpdates() {

    }

    /**
     * functie care creste varsta copiilor ramasi in lista Mosului cu 1 la
     * inceputul urmatorului an
     */
    public static void increaseAge(final Input input) {
        for (Child child : input.getInitialData().getChildren()) {
            int age = child.getAge();
            age++;
            child.setAge(age);
        }
    }

    /**
     * functie care elimina copiii care fac parte din categoria YoungAdult
     * din lista mosului
     */
    public static void checkForYoungAdults(final Input input) {
        input.getInitialData().getChildren().removeIf(child ->
                child.getAge() > Constants.TEEN_MAX_AGE);
    }

    /**
     * functie care adauga copii noi in lista Mosului
     */
    public static void addNewChildren(final Input input, final int i,
                                      final Map<Integer, List<Double>> niceScoreHistoryMap) {
        for (Child child : input.getAnnualChanges().get(i).getNewChildren()) {
            input.getInitialData().getChildren().add(child);
            List<Double> niceScoreHistory = new ArrayList<>();
            niceScoreHistory.add(child.getNiceScore());
            niceScoreHistoryMap.put(child.getId(), niceScoreHistory);
        }
    }

    /**
     * functie care inlocuieste vechiul buget al Mosului cu bugetul nou
     */
    public static void updateSantaBudget(final Input input, final int i) {
        input.setSantaBudget(input.getAnnualChanges().get(i).getNewSantaBudget());
    }

    /**
     * functie care adauga cadouri in lista de cadouri a Mosului
     */
    public static void addNewGifts(final Input input, final int i) {
        for (Gift gift : input.getAnnualChanges().get(i).getNewGifts()) {
            input.getInitialData().getSantaGiftsList().add(gift);
        }
    }
}
