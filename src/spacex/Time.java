package spacex;

public class Time implements Comparable<Time> {
    private int hour;
    private int minutes;

    public Time() {
        this(5, 30);
    }

    public Time(String time){
        String[] parts = time.split(":");
        this.hour = Integer.parseInt(parts[0]);
        this.minutes = Integer.parseInt(parts[1]);
    }

    public Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Time)) return false;

        Time otherTime = (Time) obj;
        return hour == otherTime.hour &&
                minutes == otherTime.minutes;
    }

    public String toCSVFormat() {
        return this.toString();
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }
}