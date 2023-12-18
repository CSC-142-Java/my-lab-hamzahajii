package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BMRCalculator {

    public static double computeBMI(double weight, int height) {
        return (double) 703 * weight / (height * height) ;
    }

    public static double computeBMR(int age, char bodyType, double weight, int height) {
        double bmrValue = 4.54545 * weight + 15.875 * height - 5 * age;
        if (bodyType == 'M')
            return bmrValue + 5;
        else
            return bmrValue - 161;
    }


    //TODO: Update missing information in methods e..g burn rate etc.
    public static void displayResults(Scanner scanner, PrintStream stream) {

        //FIXME: convert to display format -> Instructor Suggestion
        String name         = getName(scanner);
        int    age          = getAge(scanner);
        char   bodyType     = getBodyType(scanner);
        double weight       = getWeight(scanner);
        int    height       = getHeight(scanner);

        double bmiValue     = computeBMI(weight, height);
        double bmrValue     = computeBMR(age, bodyType, weight, height);
        double lowValue     = computeLowEndHealthyWeight(height);
        double highValue    = computeHighEndHealthyWeight(height);

        //This is using the ternary operator
        String bodyValue    = (bodyType == 'F') ? "Female" : "Male";

        String category     = getWeightCategory(bmiValue);

        stream.println();
        stream.println();
        stream.println("===================================================================");
        stream.println("\t\t R  E  S  U  L   T   S");
        stream.printf("%-15s \t\t %-10s   \n", "NAME", name);
        stream.printf("%-15s \t\t %-10d   \n", "AGE", age);
        stream.printf("%-15s \t\t %-10s   \n", "BODY TYPE", bodyValue);
        stream.printf("%-15s \t\t %-10.1f lbs \n", "WEIGHT", weight);
        stream.printf("%-15s \t\t %-10d inches \n", "HEIGHT", height);
        stream.printf("%-15s \t\t %-10s calories  \n", "BMR VALUE", bmrValue);
        stream.printf("%-15s \t\t %-10s   \n", "BURN RATE", getBurnRate(bmrValue));
        stream.printf("%-15s \t\t %-10s   \n", "BMI VALUE", bmiValue);
        stream.println("===================================================================");

    }


    public static int getAge(Scanner scanner){
        //(1) show a prompt the tells the user how to enter the information the way you want
        String prompt = "\nEnter age e.g. 21";
        System.out.println(prompt);

        //(2) Take value as string to be parsed into integers
        String value = scanner.next();

        //(3) TODO: VALIDATION check of age
        //          use repetition control to validate proper format
        while (!isValidInteger(value)){
            System.out.printf("\nInvalid Entry: %s. Try something like 21\n", value);
            // prompt the user for the input again
            System.out.println(prompt);
            //store the information again to check again
            value = scanner.next();
        }

        //(4) return value once valid
        return Integer.parseInt(value);
    }

    public static char getBodyType(Scanner scanner){
        String prompt = "\nEnter bodyType e.g. male";
        System.out.println(prompt);
        String value = scanner.next();

        while (!isValidBodyType(value)) {
            System.out.println("Incorrect");
            System.out.println(prompt);
            value = scanner.next();
        }

        return value.charAt(0);
    }


    public static String getBurnRate(double calories) {
        if (calories < 1200) {
            return "LOW";
        } else if (calories >= 1200 && calories <= 2000) {
            return "MODERATE";
        } else {
            return "HIGH";
        }
    }


    public static boolean isValidBodyType(String value) {
        char type =  value.toUpperCase().charAt(0);
        return type == 'M' || type == 'F';
    }


    public static int getFeet(String value){
        //The string value should be 5' -> 5'9"
        int feetEnd      = value.indexOf("'");
        String feetValue = value.substring(0, feetEnd);
        return Integer.parseInt(feetValue);
    }


    public static int getHeight(Scanner scanner){
        //(1) show a prompt the tells the user how to enter the information the way you want
        String prompt = "\nEnter height in feet and inches, e.g. 5'9\"";
        System.out.println(prompt);

        //(2) Take value as string to be parsed into integers
        String value = scanner.next();

        //(3)TODO: create a validation for when they enter the wrong information (if NOT Valid)
        while (!isValidHeight(value)){
            System.out.printf("\nInvalid Entry: %s. \nTry something like : 5'\"9", value);
            // prompt the user for the input again
            System.out.println(prompt);
            //store the information again to check again
            value = scanner.next();
        }

        //(4) if VALID information do the following
        int feet = getFeet(value);
        int inches = getInches(value);

        //(5) return the complete/total height in inches
        return getTotalHeightInInches(feet, inches);
    }

    public static String getName(Scanner scanner){
        String firstName = scanner.next();
        String lastName = scanner.next();
        return firstName + " " + lastName;
    }


    public static int getTotalHeightInInches(int feet, int inches){
        return 12 * feet + inches;
    }


    public static int getInches(String value){
        //The string value should be '9" -> 5'9"
        int inchesStart     = value.indexOf("'") + 1;
        int inchesEnd       = value.indexOf("\"");
        String inchesValue  = value.substring(inchesStart, inchesEnd);
        return Integer.parseInt(inchesValue);   // converts a string to an integer
    }


    public static double getWeight(Scanner scanner){
        //(1) show a prompt the tells the user how to enter the information the way you want
        String prompt = "\nEnter weight in lbs e.g. 149.2";
        System.out.println(prompt);

        //(2) Take value as string to be parsed into integers
        String value = scanner.next();

        //(3) TODO: VALIDATION check of weight
        //          use repetition control to validate proper format
        while (!isValidWeight(value)){
            System.out.printf("\nInvalid Entry: %s. Try something like 149.2\n", value);
            // prompt the user for the input again
            System.out.println(prompt);
            value = scanner.next();
        }

        //(4) return value once valid
        return Double.parseDouble(value);
    }


    public static boolean isValidHeight(String value){
        //Create VALIDATION  with try-catch EXCEPTIONS
        try{
            //The thing for us to try, if it breaks throw an exception
            getFeet(value);
            getInches(value);
            return true;
        }catch(Exception exception){
            //If it does not work  catch it with this remedy
            //(1) Create a prompt for the user
            String prompt = "\nTry something like : 5'\"9";
            return false;
        }
    }

    public static boolean isValidInteger(String value){
        //Create VALIDATION  with try-catch EXCEPTIONS
        try{
            //The thing for us to try, if it breaks throw an exception
            Integer.parseInt(value);
            return true;
        }catch(Exception exception){
            //If it does not work  catch it with this remedy
            //(1) Create a prompt for the user
            String prompt = "\nTry something like : 24";
            return false;
        }
    }

    public static boolean isValidWeight(String value){
        //Create VALIDATION  with try-catch EXCEPTIONS
        try{
            //The thing for us to try, if it breaks throw an exception
            Double.parseDouble(value);
            return true;
        }catch(Exception exception){
            //If it does not work  catch it with this remedy
            //(1) Create a prompt for the user
            String prompt = "\nTry something like : 149.2";
            return false;
        }
    }

    public static String getWeightCategory(double bmiValue) {
        if (bmiValue < 18.5) {
            return "UNDERWEIGHT";
        } else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
            return "HEALTHY";
        } else if (bmiValue >= 25.0 && bmiValue <= 29.9) {
            return "OVERWEIGHT";
        } else {
            return "OBESE";
        }




    }
    public static double computeHighEndHealthyWeight(int height) {
        return (24.9 / 703) * (height * height);
    }

    public static double computeLowEndHealthyWeight(int height){
        return (18.5 / 703) * (height * height);
    }


    public static char start(char key){
        //get input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // prompt for quitting the program
        String prompt = "Enter 'q' to quit or any other key to continue.";

        // run the program until 'q' is entered.
        while (key != 'q'){

            System.out.println("Enter your name bodyType in the space below");
            String name     = scanner.next();
            String bType    = scanner.next();
            char bodyType   = bType.toUpperCase().charAt(0); //Taking the first letter of conversion to char
            int age         = getAge(scanner);
            int height      = getHeight(scanner);
            double weight   = getWeight(scanner);

            System.out.printf("Your BMI is %5.2f \n", computeBMI(weight, height));
            System.out.printf("Your BMR is %5.2f \n", computeBMR(age, bodyType, weight, height));

            //TODO: check to see if the key value has changed
            System.out.println();
            System.out.println(prompt);
            key = scanner.next().charAt(0);
        }

        return key;
    }


    public static void toFile() throws FileNotFoundException {

        String inputLocation = "." + File.separator + "data" + File.separator + "bmr.txt";
        String outputLocation = "." + File.separator + "results" + File.separator + "bmr_results.txt";

        File inputFile        = new File(inputLocation);
        Scanner fileStream    = new Scanner(inputFile);
        PrintStream outStream = new PrintStream(outputLocation);

        while (fileStream.hasNextLine()){
            displayResults(fileStream, outStream);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        //TODO: USe the design document on Canvas to complete this program

//        start('y');
        toFile();
    }

}