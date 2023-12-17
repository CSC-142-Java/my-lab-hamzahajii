package spacex;

public class Date  implements Comparable<Date> {
    private int day;
    private Month month;
    private int year;

    public Date() {
        this(1,Month.JANUARY, 2000);
    }

    public Date(int day, Month month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(String date) {
        String[] parts = date.split("/");
        if (parts.length == 3) {
            this.day = Integer.parseInt(parts[0]);
            this.month = Month.valueOf(parts[1].toUpperCase());
            this.year = Integer.parseInt(parts[2]);
        } else {
            throw new IllegalArgumentException("Invalid date format: " + date);
        }
    }


    public static Date parseDate(String dateString)
    {
        return new Date(/* parsed values */);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date date = (Date) obj;
        return day == date.day && year == date.year && month == date.month;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(day, month, year);
//    }

    @Override
    public String toString() {
        return String.format("%d %s %d", day, month, year);
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
}
