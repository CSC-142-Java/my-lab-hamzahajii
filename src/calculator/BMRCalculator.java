package calculator;

import java.util.Scanner;
public class BMRCalculator {

    public static double computeBMI(double weight, int height) {

        return (double) 703 * weight / (height * height) ;
    }

    public static double computeBMR(int age, char bodyType, double weight, int height) {
        double bmrValue = 4.54545 * weight + 15.875 * height - 5 * age;
        if (bodyType == 'F')
            return bmrValue + 5;
        else
            return bmrValue - 161;
    }

    public static void main(String[] args) {
        //TODO: USe the design document on Canvas to complete this program
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name age body type weight and height in the space below");
        String name = scanner.next();
        int age = scanner.nextInt();
        String bType = scanner.next();
        char bodyType = bType.toUpperCase().charAt(0); //Taking the first letter of conversion to char
        double weight = scanner.nextDouble();
        int height = scanner.nextInt();

        System.out.printf("Your BMI is %5.2f \n", computeBMI(weight, height));
        System.out.printf("Your BMR is %5.2f \n", computeBMR(age, bodyType, weight, height));


    }

}