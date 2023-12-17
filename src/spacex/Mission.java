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
    private Mission(String flightNumber, Date launchDate, Time launchTime, String launchSite, String vehicleType, Payload payload, Customer customer, String missionOutcome, String failureReason, String landingType, String landingOutcome) {
        this.flightNumber = flightNumber;
        this.launchDate = launchDate;
        this.launchTime = launchTime;
        this.launchSite = launchSite;
        this.vehicleType = vehicleType;
        this.payload = payload;
        this.customer = customer;
        this.missionOutcome = missionOutcome;
        this.failureReason = failureReason;
        this.landingType = landingType;
        this.landingOutcome = landingOutcome;
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

    public String toCSVFormat() {
        return String.join(",",
                flightNumber,
                launchDate.toString(),
                launchTime.toString(),
                launchSite,
                vehicleType,
                payload == null ? "" : payload.toString(),
                customer == null ? "" : customer.toString(),
                missionOutcome,
                failureReason,
                landingType,
                landingOutcome);
    }

    @Override
    public int compareTo(Mission otherMission) {
        // Assuming spacex.Date implements Comparable
        return this.launchDate.compareTo(otherMission.launchDate);
    }

    @Override
    public String toString() {
        // Implement toString method
        // Return a string representation of the mission, e.g., for debugging
        return String.format("Mission{%s, %s, %s}", flightNumber, launchDate, launchTime);
    }

    // Builder class
    public static class Builder {
        private Mission mission;

        public Builder() {
            this.mission = new Mission();
        }

        public Builder setFlightNumber(String flightNumber) {
            mission.flightNumber = flightNumber;
            return this;
        }

        public Builder setLaunchDate(Date launchDate) {
            mission.launchDate = launchDate;
            return this;
        }

        public Builder setLaunchTime(Time launchTime) {
            mission.launchTime = launchTime;
            return this;
        }

        public Builder setLaunchSite(String launchSite) {
            mission.launchSite = launchSite;
            return this;
        }

        public Builder setVehicleType(String vehicleType) {
            mission.vehicleType = vehicleType;
            return this;
        }

        public Builder setPayload(Payload payload) {
            mission.payload = payload;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            mission.customer = customer;
            return this;
        }

        public Builder setMissionOutcome(String missionOutcome) {
            mission.missionOutcome = missionOutcome;
            return this;
        }

        public Builder setFailureReason(String failureReason) {
            mission.failureReason = failureReason;
            return this;
        }

        public Builder setLandingType(String landingType) {
            mission.landingType = landingType;
            return this;
        }

        public Builder setLandingOutcome(String landingOutcome) {
            mission.landingOutcome = landingOutcome;
            return this;
        }

        public Mission build() {
            return mission;
        }
    }
}