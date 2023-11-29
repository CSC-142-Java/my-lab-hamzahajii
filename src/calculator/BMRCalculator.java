package calculator;

import java.util.Scanner;

public class BMRCalculator {

    public static double computeBMI(double weight, int height) {
        return 703.0 * weight / (height * height);
    }

    public static double computeBMR(int age, char bodyType, double weight, int height) {
        double bmrValue = 4.54545 * weight + 15.875 * height - 5 * age;
        return (bodyType == 'F') ? bmrValue + 5 : bmrValue - 161;
    }

    public static int getAge(Scanner scanner) {
        System.out.println("Enter age e.g. 21");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid Entry. Try something like 21");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int getFeet(String value) {
        int feetEnd = value.indexOf("'");
        String feetValue = value.substring(0, feetEnd);
        return Integer.parseInt(feetValue);
    }

    public static int getHeight(Scanner scanner) {
        System.out.println("Enter height in feet and inches, e.g. 5'9\"");
        String value = scanner.next();

        while (!isValidHeight(value)) {
            System.out.println("Invalid Entry. Try something like: 5'9\"");
            value = scanner.next();
        }

        int feet = getFeet(value);
        int inches = getInches(value);
        return getTotalHeightInInches(feet, inches);
    }

    public static int getTotalHeightInInches(int feet, int inches) {
        return 12 * feet + inches;
    }

    public static int getInches(String value) {
        int inchesStart = value.indexOf("'") + 1;
        int inchesEnd = value.indexOf("\"");
        String inchesValue = value.substring(inchesStart, inchesEnd);
        return Integer.parseInt(inchesValue);
    }

    public static double getWeight(Scanner scanner) {
        System.out.println("Enter weight in lbs e.g. 149.2");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid Entry. Try something like 149.2");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static boolean isValidHeight(String value) {
        try {
            getFeet(value);
            getInches(value);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        char key = 'y';

        while (key != 'q') {
            System.out.println("Enter your name bodyType in the space below");
            String name = scanner.next();
            String bType = scanner.next();
            char bodyType = bType.toUpperCase().charAt(0);
            int age = getAge(scanner);
            int height = getHeight(scanner);
            double weight = getWeight(scanner);

            System.out.printf("Your BMI is %5.2f \n", computeBMI(weight, height));
            System.out.printf("Your BMR is %5.2f \n", computeBMR(age, bodyType, weight, height));

            System.out.println("Enter 'q' to quit or any other key to continue.");
            key = scanner.next().charAt(0);
        }
    }

    public static void main(String[] args) {
        start();
    }
}
