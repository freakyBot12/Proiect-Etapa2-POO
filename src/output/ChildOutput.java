package output;

import actions.BudgetCalculator;
import input.Child;
import input.Gift;

import java.util.ArrayList;
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

    public static class Builder {
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

        public Builder (Child child) {
            this.id = child.getId();
            this.lastName = child.getLastName();
            this.firstName = child.getFirstName();
            this.city = child.getCity();
            this.age = child.getAge();
            this.giftsPreferences = child.getGiftsPreferences();
        }

        public Builder averageScore(double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public Builder niceScoreHistory(List<Double> niceScoreHistory) {
            this.niceScoreHistory = niceScoreHistory;
            return this;
        }

        public Builder assignedBudget(double assignedBudget) {
            this.assignedBudget = assignedBudget;
            return this;
        }

        public Builder receivedGifts(List<Gift> receivedGifts) {
            this.receivedGifts = receivedGifts;
            return this;
        }

        public ChildOutput build() {
            return new ChildOutput(this);
        }

    }
    private ChildOutput(Builder builder) {
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
