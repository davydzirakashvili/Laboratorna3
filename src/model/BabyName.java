package model;

public class BabyName {

    private String name;

    private String gender;

    private String ethnicity;

    private int count;

    private int rank;

    public BabyName(
            String name,
            String gender,
            String ethnicity,
            int count,
            int rank) {

        this.name = name;

        this.gender = gender;

        this.ethnicity = ethnicity;

        this.count = count;

        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public int getCount() {
        return count;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {

        return "BabyName{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", count=" + count +
                ", rank=" + rank +
                '}';
    }
}