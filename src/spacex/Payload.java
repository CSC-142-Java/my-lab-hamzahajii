package spacex;

public class Payload implements Comparable<Payload> {
    private String name;
    private String type;
    private double mass;
    private String orbit;

    public Payload(String payload) {
    }

    public Payload(String name, String type, double mass, String orbit) {
        // Constructor with parameters
        this.name = name;
        this.type = type;
        this.mass = mass;
        this.orbit = orbit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Payload)) return false;

        Payload otherPayload = (Payload) obj;
        return name.equals(otherPayload.name) &&
                type.equals(otherPayload.type) &&
                mass == otherPayload.mass &&
                orbit.equals(otherPayload.orbit);
    }

    @Override
    public int compareTo(Payload otherPayload)
    {
        return Double.compare(this.mass, otherPayload.mass);
    }

    @Override
    public String toString() {

        return String.format("%s, %s, %.2f kg, %s", name, type, mass, orbit);
    }
}