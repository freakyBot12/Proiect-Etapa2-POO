package actions;

import input.Child;
import input.Gift;
import input.Input;

import java.util.List;

public final class ChosenGiftByYellowElf {
    private ChosenGiftByYellowElf() {

    }

    /**
     * functie care ii atribuie un cadou unui copil care are elful "yellow"
     * (doar daca sunt respectate conditiile impuse de elful "yellow")
     */
    public static void searchChosenGiftByYellowElf(final Child child,
                                                   final Input input,
                                                   final List<Gift> receivedGifts) {
        int ok = 0;
        double minGiftPrice = Double.MAX_VALUE;
        Gift chosenGift = new Gift();
        for (Gift gift : input.getInitialData().getSantaGiftsList()) {
            if (gift.getCategory().equals(child.getGiftsPreferences().get(0))) {
                if (gift.getPrice() < minGiftPrice) {
                    ok = 1;
                    minGiftPrice = gift.getPrice();
                    chosenGift = gift;
                }
            }
        }
        if (ok == 1 && chosenGift.getQuantity() > 0) {
            int numberOfGifts = chosenGift.getQuantity();
            numberOfGifts--;
            chosenGift.setQuantity(numberOfGifts);
            receivedGifts.add(chosenGift);
        }
    }
}
