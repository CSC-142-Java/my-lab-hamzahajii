package spacex;

public class Mission implements Comparable<Mission> {
    private String flightNumber;
    private Date launchDate;
    private Time launchTime;
    private String launchSite;
    private String vehicleType;
    private Payload payload;
    private Customer customer;
    private String missionOutcome;
    private String failureReason;
    private String landingType;
    private String landingOutcome;

    // Default constructor
    public Mission() {}

    // Constructor with parameters
    public Mission(Builder builder) {
        this.flightNumber = builder.flightNumber;
        this.launchDate = builder.launchDate;
        this.launchTime = builder.launchTime;
        this.launchSite = builder.launchSite;
        this.vehicleType = builder.vehicleType;
        this.payload = builder.payload;
        this.customer = builder.customer;
        this.missionOutcome = builder.missionOutcome;
        this.failureReason = builder.failureReason;
        this.landingType = builder.landingType;
        this.landingOutcome = builder.landingOutcome;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Time getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(Time launchTime) {
        this.launchTime = launchTime;
    }

    public String getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(String launchSite) {
        this.launchSite = launchSite;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMissionOutcome() {
        return missionOutcome;
    }

    public void setMissionOutcome(String missionOutcome) {
        this.missionOutcome = missionOutcome;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public String getLandingOutcome() {
        return landingOutcome;
    }

    public void setLandingOutcome(String landingOutcome) {
        this.landingOutcome = landingOutcome;
    }


    public boolean equals(Object obj) {
        Mission mission = (Mission) obj;
        return flightNumber.equals(mission.flightNumber) &&
                launchDate.equals(mission.launchDate) &&
                launchTime.equals(mission.launchTime) &&
                launchSite.equals(mission.launchSite) &&
                vehicleType.equals(mission.vehicleType) &&
                payload.equals(mission.payload) &&
                customer.equals(mission.customer) &&
                missionOutcome.equals(mission.missionOutcome) &&
                failureReason.equals(mission.failureReason) &&
                landingType.equals(mission.landingType) &&
                landingOutcome.equals(mission.landingOutcome);
    }

    @Override
    public int compareTo(Mission otherMission) {
        // Assuming spacex.Date implements Comparable
        return this.launchDate.compareTo(otherMission.launchDate);
    }

    public String toCSVFormat() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                flightNumber, launchDate.toCSVFormat(), launchTime.toCSVFormat(), launchSite, vehicleType,
                payload.toCSVFormat(), customer.toCSVFormat(), missionOutcome,
                failureReason, landingType, landingOutcome);
    }

    @Override
    public String toString() {
        String             dashLine     = "---------------------------------------------";
        StringBuilder     builder     = new StringBuilder(dashLine + "\n");
        int               size         = 11;
        DataMap[]          map            = new DataMap[size];
        map[0]         = new DataMap("Flight Number: "        , flightNumber);
        map[1]         = new DataMap("Launch Date: "        , launchDate.toString());
        map[2]         = new DataMap("Launch Time: "        , launchTime.toString());
        map[3]         = new DataMap("Launch Site: "        , launchSite);
        map[4]         = new DataMap("Vehicle Type: "        , vehicleType);
        map[5]         = new DataMap("\nPayload: "            , payload.toString());
        map[6]         = new DataMap("Customer: "            , customer.toString());
        map[7]         = new DataMap("Mission Outcome: "    , missionOutcome);
        map[8]         = new DataMap("Failure Reason: "    , failureReason);
        map[9]         = new DataMap("Landing Type: "        , landingType);
        map[10]     = new DataMap("Landing Outcome: "    , landingOutcome);

        for (int i = 0; i < size; i++) {
            builder.append(String.format("%-18s %-4s \n", map[i].name, map[i].value));
        }

        return builder.toString();
    }

    // Builder class
    public static class Builder {
        String flightNumber;
        Date launchDate;
        Time launchTime;
        String launchSite;
        String vehicleType;
        Payload payload;
        Customer customer;
        String missionOutcome;
        String failureReason;
        String landingType;
        String landingOutcome;

        public Builder() {
            this.flightNumber = " ";
            this.launchDate = new Date();
            this.launchTime = new Time();
            this.launchSite = " ";
            this.vehicleType = " ";
            this.payload = new Payload();
            this.customer = new Customer();
            this.missionOutcome = " ";
            this.failureReason = " ";
            this.landingType = " ";
            this.landingOutcome = " ";
        }

        public Builder setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder setLaunchDate(Date launchDate) {
            this.launchDate = launchDate;
            return this;
        }

        public Builder setLaunchDate(String launchDate) {
            this.launchDate = new Date(launchDate);
            return this;
        }

        public Builder setLaunchTime(String launchTime) {
            this.launchTime = new Time(launchTime);
            return this;
        }

        public Builder setLaunchTime(Time launchTime) {
            this.launchTime = launchTime;
            return this;
        }

        public Builder setLaunchSite(String launchSite) {
            this.launchSite = launchSite;
            return this;
        }

        public Builder setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Builder setPayload(Payload payload) {
            this.payload = payload;
            return this;
        }

        public Builder setPayload(String value) {
            this.payload = new Payload(value);
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }


        public Builder setMissionOutcome(String missionOutcome) {
            this.missionOutcome = missionOutcome;
            return this;
        }

        public Builder setFailureReason(String failureReason) {
            this.failureReason = failureReason;
            return this;
        }

        public Builder setLandingType(String landingType) {
            this.landingType = landingType;
            return this;
        }

        public Builder setLandingOutcome(String landingOutcome) {
            this.landingOutcome = landingOutcome;
            return this;
        }

        public Mission build() {
            return new Mission(this);
        }
    }

}