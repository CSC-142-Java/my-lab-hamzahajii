package spacex;

public class Payload implements Comparable<Payload> {
    private String name;
    private String type;
    private double mass;
    private String orbit;

    public Payload() {
        this(" ", " ", 0.0, " ");
    }

    public Payload(String payload) {
        String[] array = payload.split(" ");
        this.name = array [0];
        this.type = array[1];
        this.mass = Double.parseDouble(array[2]);
        this.orbit = array[3];
    }

    public Payload(String name, String type, double mass, String orbit) {
        // Constructor with parameters
        this.name = name;
        this.type = type;
        this.mass = mass;
        this.orbit = orbit;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getOrbit(){
        return orbit;
    }

    public double getMass(){
        return mass;
    }

    @Override
    public int compareTo(Payload otherPayload)
    {
        return Double.compare(this.mass, otherPayload.mass);
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


    public String toCSVFormat() {

        return String.format("%s, %s, %.2f kg, %s", name, type, mass, orbit);
    }

    @Override
    public String toString(){
        String                  dashLine        = "********************************";
        StringBuilder           builder         = new StringBuilder(dashLine + "\n");
        int                     size            = 4;
        DataMap[]               map             = new DataMap[size];

        map[0] = new DataMap("Name:  "           ,name);
        map[1] = new DataMap("Type:  "           ,type);
        map[2] = new DataMap("Mass:  "           ,Double.toString(mass));
        map[3] = new DataMap("Orbit:  "          ,orbit);

        for (DataMap dataMap : map) {
            builder.append(String.format("\t%-14s %-4s \n", dataMap.name, dataMap.value));
        }

        return builder.toString().stripTrailing();
    }
}