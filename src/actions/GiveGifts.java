package actions;

import input.Child;
import input.Input;
import output.Output;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class GiveGifts {
    private GiveGifts() {

    }

    /**
     * simularea propriu-zisa a primei runde si a celorlalte numberOfYears runde.
     * Dupa runda 0, este creat un Hashmap care contine toti copiii din lista
     * Mosului si toate scorurile de cumintenie acordate acestora in numberOfYears + 1
     * ani
     */
    public static void execute(final Input input, final Output output) {
        Round0.execute(input, output);
        Map<Integer, List<Double>> niceScoreHistoryMap = new LinkedHashMap<>();
        for (Child child : input.getInitialData().getChildren()) {
            List<Double> scoreHistory = new ArrayList<>();
            scoreHistory.add(child.getNiceScore());
            niceScoreHistoryMap.put(child.getId(), scoreHistory);
        }
        NextRounds.execute(input, output, niceScoreHistoryMap);
    }
}
