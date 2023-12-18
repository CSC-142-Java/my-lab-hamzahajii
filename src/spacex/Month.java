package spacex;

public enum Month {
    //TODO: update with enumerated pattern discussed in design documentation
    JAN("Jan"),
    FEB("Feb"),
    MAR("Mar"),
    APR("Apr"),
    MAY("May"),
    JUN("Jun"),
    JUL("Jul"),
    AUG("Aug"),
    SEP("Sep"),
    OCT("Oct"),
    NOV("Nov"),
    DEC("Dec");


    private final String value;

    Month(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}