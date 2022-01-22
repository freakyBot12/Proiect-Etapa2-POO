package factory;

public final class SortFactory {
    /** functia creeaza un obiect care va sorta lista de copii, in functie
     * strategia de asignare a cadourilor, data ca parametru
     */
    public SortSantaChildrenList getSortType(final String strategy) {
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
