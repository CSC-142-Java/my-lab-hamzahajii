package spacex;

public class Date  implements Comparable<Date> {
    private int day;
    private Month month;
    private int year;

    public Date() {
        this(1, Month.JAN , 2000);
    }


    public Date(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public Date(String date) {
        String[] parts = date.split("-");
            this.day = Integer.parseInt(parts[0]);
            this.month = Month.valueOf(parts[1].toUpperCase());
            this.year = Integer.parseInt(parts[2]);
    }


//    public static Date parseDate(String dateString)
//    {
//        return new Date(/* parsed values */);
//    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }


    @Override
    public int compareTo(Date otherDate) {
        int result;
        // Assuming spacex.Month implements Comparable
        int yearComparison = Integer.compare(this.year, otherDate.year);
        if (yearComparison != 0) {
            result = yearComparison;
        } else {
            int monthComparison = this.month.compareTo(otherDate.month);
            if (monthComparison != 0) {
                result = monthComparison;
            } else {
                result = Integer.compare(this.day, otherDate.day);
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date other){
            return day == other.day && year == other.year && month == other.month;
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(day, month, year);
//    }

    public String toCSVFormat(){
        return this.toString();
    }

    @Override
    public String toString() {
        String date = String.format("%d-%s-%02d", day, month, year);
        return date.equals("0-Jan-0") ? "" : date;
    }
}
