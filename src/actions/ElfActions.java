package actions;

import input.Child;

public class ElfActions {

    public static double pinkElf(double averageScore) {
        return averageScore + (averageScore * 30) / 100;
    }

    public static double blackElf(double averageScore) {
        return averageScore - (averageScore * 30) / 100;
    }

    public static double calculatedBudgetByElf(Child child, double averageScore) {
        if (child.getElf().equals("pink")) {
            return pinkElf(averageScore);
        }
        if (child.getElf().equals("black")) {
            return blackElf(averageScore);
        } else {
            return averageScore;
        }
    }
}
