package actions;

import input.Child;
import input.ChildUpdate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class UpdateChild {
    private UpdateChild() {

    }

    /**
     * functie care adauga, daca este cazul, un nou scor de cumintenie in lista de scoruri
     * a copilului dat ca parametru
     */
    public static void updateNiceScoreHistory(final ChildUpdate childUpdate,
                                              final Child child,
                                              final Map<Integer,
                                                      List<Double>> niceScoreHistoryMap) {
        if (childUpdate.getNiceScore() != null) {
            List<Double> niceScoreHistory = niceScoreHistoryMap.get(child.getId());
            niceScoreHistory.add(childUpdate.getNiceScore());
            niceScoreHistoryMap.put(child.getId(), niceScoreHistory);
        }
    }

    /**
     * functie care actualizeaza, daca este cazul, lista de preferinte a
     * copilului dat ca parametru
     */
    public static void updateGiftsPreferences(final ChildUpdate childUpdate, final Child child) {
        if (!childUpdate.getGiftsPreferences().isEmpty()) {
            for (String preference : child.getGiftsPreferences()) {
                if (!childUpdate.getGiftsPreferences().contains(preference)) {
                    childUpdate.getGiftsPreferences().add(preference);
                }
            }
            List<String> giftsPreferencesWithNoDuplicates =
                    childUpdate.getGiftsPreferences().stream().distinct()
                            .collect(Collectors.toList());
            child.setGiftsPreferences(giftsPreferencesWithNoDuplicates);

        }
    }

    /**
     * aceasta functie executa functiile de mai sus daca id-ul copilului este
     * gasit in lista de update-uri pentru copii a Mosului
     */
    public static int execute(final ChildUpdate childUpdate, final Child child,
                              final Map<Integer, List<Double>> niceScoreHistoryMap) {
        if (childUpdate.getId() == child.getId()) {
            updateNiceScoreHistory(childUpdate, child, niceScoreHistoryMap);
            updateGiftsPreferences(childUpdate, child);
            child.setElf(childUpdate.getElf());
            return 1;
        }
        return 0;
    }
}
