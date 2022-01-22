package output;

import input.Child;
import input.Gift;

import java.util.List;

public final class ChildOutput {

    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private int age;
    private List<String> giftsPreferences;
    private double averageScore;
    private List<Double> niceScoreHistory;
    private double assignedBudget;
    private List<Gift> receivedGifts;

    public static final class Builder {
        private final int id;
        private final String lastName;
        private final String firstName;
        private final String city;
        private final int age;
        private final List<String> giftsPreferences;
        private double averageScore;
        private List<Double> niceScoreHistory;
        private double assignedBudget;
        private List<Gift> receivedGifts;

        public Builder(final Child child) {
            this.id = child.getId();
            this.lastName = child.getLastName();
            this.firstName = child.getFirstName();
            this.city = child.getCity();
            this.age = child.getAge();
            this.giftsPreferences = child.getGiftsPreferences();
        }

        /**
         * functie de setare a fieldului "averageScore:
         */
        public Builder setAverageScore(final double parameterAverageScore) {
            this.averageScore = parameterAverageScore;
            return this;
        }

        /**
         * functie de setare a fieldului "niceScoreHistory:
         */
        public Builder setNiceScoreHistory(final List<Double> parameterNiceScoreHistory) {
            this.niceScoreHistory = parameterNiceScoreHistory;
            return this;
        }

        /**
         * functie de setare a fieldului "assignedBudget:
         */
        public Builder setAssignedBudget(final double parameterAssignedBudget) {
            this.assignedBudget = parameterAssignedBudget;
            return this;
        }

        /**
         * functie de setare a fieldului "receivedGifts:
         */
        public Builder setReceivedGifts(final List<Gift> parameterReceivedGifts) {
            this.receivedGifts = parameterReceivedGifts;
            return this;
        }

        /**
         * functia creeaza o instanta a clasei ChildOutput, care va contine informatiile
         * din Builder
         */
        public ChildOutput build() {
            return new ChildOutput(this);
        }

    }

    private ChildOutput(final Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.city = builder.city;
        this.age = builder.age;
        this.giftsPreferences = builder.giftsPreferences;
        this.averageScore = builder.averageScore;
        this.niceScoreHistory = builder.niceScoreHistory;
        this.assignedBudget = builder.assignedBudget;
        this.receivedGifts = builder.receivedGifts;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
