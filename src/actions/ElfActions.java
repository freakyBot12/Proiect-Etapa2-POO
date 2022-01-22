package actions;

import common.Constants;
import input.Child;

public final class ElfActions {
    private ElfActions() {

    }

    /** functie care creste bugetul copilului cu elful "pink" cu 30% */
    public static double pinkElf(final double allocatedBudget) {
        return allocatedBudget + (allocatedBudget * Constants.PERCENT)
                / Constants.BUDGET_MODIFICATION_VARIABLE;
    }

    /** functie care scade bugetul copilului cu elful "black" cu 30% */
    public static double blackElf(final double allocatedBudget) {
        return allocatedBudget - (allocatedBudget * Constants.PERCENT)
                / Constants.BUDGET_MODIFICATION_VARIABLE;
    }

    /** functia recalculeaza bugetul alocat unui copil, in functie de elful pe care
     * il are ("pink" sau "black"; bugetul copiilor cu elfii "white" sau "yellow"
     * nu va suferi modificari)
     */
    public static double calculatedBudgetByElf(final Child child, final double allocatedBudget) {
        if (child.getElf().equals("pink")) {
            return pinkElf(allocatedBudget);
        }
        if (child.getElf().equals("black")) {
            return blackElf(allocatedBudget);
        } else {
            return allocatedBudget;
        }
    }
}
