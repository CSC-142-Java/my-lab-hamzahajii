package spacex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Controller {
    static String csvFileHeader;

    private static spacex.Month parseMonth(String month) {
        return spacex.Month.valueOf(month.toUpperCase());
    }

    private static Mission parse(String line) throws IllegalArgumentException {
        String[] str = line.split(",");
        String[] column = new String[16];

        // copy data into a larger array to fix issues with splitting
        for (int i = 0; i < str.length; i++)
            column[i] = str[i];

        // null values at the end set to empty
        if (str.length < column.length) {
            for (int i = str.length; i < column.length; i++) {
                column[i] = "";
            }
        }


        String      flightNumber    = column[0];
        Date        launchDate      = new Date(column[1]);
        Time        launchTime      = new Time(column[2]);
        String      launchSite      = column[3];
        String      vehicleType     = column[4];
        double      mass            = column[7].isEmpty() ? 0 : Double.parseDouble(column[7]);
        Payload     payload         = new Payload(column[5], column[6], mass, column[8]);
        Customer    customer        = new Customer(column[9], column[10], column[11]);
        String      missionOutcome  = column[12];
        String      failureReason   = column[13];
        String      landingType     = column[14];
        String      landingOutcome  = column[15];


        return new Mission.Builder()
                .setFlightNumber(flightNumber)
                .setLaunchDate(launchDate)
                .setLaunchTime(launchTime)
                .setLaunchSite(launchSite)
                .setVehicleType(vehicleType)
                .setPayload(payload)
                .setCustomer(customer)
                .setMissionOutcome(missionOutcome)
                .setFailureReason(failureReason)
                .setLandingType(landingType)
                .setLandingOutcome(landingOutcome)
                .build();
    }

    public static void read(List<Mission> list, String inputLocation) throws FileNotFoundException {
        File file = new File(inputLocation);

        try (Scanner input = new Scanner(file)) {
            csvFileHeader = input.nextLine(); // Read the CSV file header

            while (input.hasNextLine()) {
                String line = input.nextLine();
                try {
                    Mission mission = parse(line);
                    list.add(mission);
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCustomersInOrder(List<Mission> list, String customer, String outputLocation)
            throws FileNotFoundException {
        String csvLocation = outputLocation + File.separator + customer + ".csv";
        String txtLocation = outputLocation + File.separator + customer + ".txt";
        File csvFile = new File(csvLocation);
        File txtFile = new File(txtLocation);
        PrintStream csvStream = new PrintStream(csvFile);
        PrintStream txtStream = new PrintStream(txtFile);

        Payload p1;
        Payload p2;
        Mission temp;

        int n = list.size();
        for(int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++) {
                p1 = list.get(j).getPayload();
                p2 = list.get(j + 1).getPayload();

                if (p1.compareTo(p2) > 0){
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }

        csvStream.println(csvFileHeader);

        for (Mission mission : list) {
            if (mission.getCustomer().getName().equals(customer)) {
                csvStream.println(mission.toCSVFormat());
                txtStream.print(mission);
            }
        }


        csvStream.close();
        txtStream.close();
    }

    public static void writePayloadsByOrder(List<Mission> list, String outputLocation) throws FileNotFoundException {
        String csvLocation = outputLocation + File.separator + "ordered_payload.csv";
        String txtLocation = outputLocation + File.separator + "ordered_payload.txt";
        File csvFile = new File(csvLocation);
        File txtFile = new File(txtLocation);
        PrintStream csvStream = new PrintStream(csvFile);
        PrintStream txtStream = new PrintStream(txtFile);

        Payload p1;
        Payload p2;
        Mission temp;

        int n = list.size();
        for(int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++) {
                p1 = list.get(j).getPayload();
                p2 = list.get(j + 1).getPayload();

                if (p1.compareTo(p2) > 0){
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }

        csvStream.println(csvFileHeader);

        for (Mission mission : list) {
                csvStream.println(mission.toCSVFormat());
                txtStream.print(mission);
            }


        csvStream.close();
        txtStream.close();
    }

    public static void intro() {
        System.out.println();
        System.out.println();
        System.out.println("====================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t  S P A C E   X    T E S T    P R O G R A M");
        System.out.println();
        System.out.println(" \t    S    T    A    R    T    I    N    G");
        System.out.println();
        System.out.println("====================================================");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String outputLocation = "." + File.separator + "results";
        String inputLocation = "." + File.separator + "data"
                + File.separator + "spacex_mission_data.csv";

        // Print intro to the console
        intro();

        // Create a list to store mission data
        List<Mission> missionList = new ArrayList<>();


        read(missionList, inputLocation);


        // Example: Print the flight numbers of all missions
        for (Mission mission : missionList) {
            System.out.println("Flight Number: " + mission.getFlightNumber());
        }

        // Write customers' missions to CSV and TXT files
        writeCustomersInOrder(missionList, "DARPA", outputLocation);

        // Write ordered payloads to CSV and TXT files
        writePayloadsByOrder(missionList, outputLocation);
    }
}