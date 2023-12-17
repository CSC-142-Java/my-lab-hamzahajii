package spacex;

public class Time implements Comparable<Time> {
    private int hour;
    private int minutes;

    public Time() {

    }

    public Time(String time) {

    }

    public Time(int hour, int minutes) {
        // Constructor with parameters
        this.hour = hour;
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Time)) return false;

        Time otherTime = (Time) obj;
        return hour == otherTime.hour &&
                minutes == otherTime.minutes;
    }

    @Override
    public int compareTo(Time otherTime) {
        // Implement comparison logic based on your requirements
        if (this.hour != otherTime.hour) {
            return Integer.compare(this.hour, otherTime.hour);
        } else {
            return Integer.compare(this.minutes, otherTime.minutes);
        }
    }

    @Override
    public String toString() {

        return String.format("%02d:%02d", hour, minutes);
    }

    public static Time parseTime(String timeString)
    {
        String[] parts = timeString.split(":");
        if (parts.length != 2) {
            System.out.println("Invalid time format: " + timeString);
            return null;
        }

        try {
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            return new Time(hour, minute);
        } catch (NumberFormatException e) {
            System.out.println("Invalid time format: " + timeString);
            return null;
        }
    }
}