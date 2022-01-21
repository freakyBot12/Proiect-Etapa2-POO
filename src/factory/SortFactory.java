package factory;

public class SortFactory {
    public SortSantaChildrenList getSortType(String strategy) {
        if (strategy.equals("id")) {
            return new SortSantaChildrenListById();
        }
        if (strategy.equals("niceScore")) {
            return new SortSantaChildrenListByNiceScore();
        }
        if (strategy.equals("niceScoreCity")) {
            return new SortSantaChildrenListByNiceScoreCity();
        }
        return null;
    }
}
