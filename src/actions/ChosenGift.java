package actions;

import input.Child;
import input.Gift;
import input.Input;

import java.util.List;

public final class ChosenGift {
    private ChosenGift() {

    }

    /**
     * functia care determina ce cadouri ii va asigna Mos Craciun copilului
     */
    public static void searchChosenGift(final Child child,
                                        final Input input,
                                        final List<Gift> receivedGifts,
                                        final double allocatedBudget) {
        double allocatedBudgetCopy = allocatedBudget;
        for (String preference : child.getGiftsPreferences()) {
            double minGiftPrice = Double.MAX_VALUE;
            Gift chosenGift = new Gift();
            for (Gift gift : input.getInitialData().getSantaGiftsList()) {
                if (gift.getCategory().equals(preference)) {
                    if (gift.getPrice() < minGiftPrice && gift.getQuantity() > 0) {
                        minGiftPrice = gift.getPrice();
                        chosenGift = gift;
                    }
                }
            }
            if (allocatedBudgetCopy - minGiftPrice >= 0) {
                int numberOfGifts = chosenGift.getQuantity();
                numberOfGifts--;
                chosenGift.setQuantity(numberOfGifts);
                receivedGifts.add(chosenGift);
                allocatedBudgetCopy -= minGiftPrice;
            }
        }
    }
}
