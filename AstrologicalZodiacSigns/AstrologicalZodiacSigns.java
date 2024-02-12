/*
* Name: Manu Sugunakumar
* Date: February 1, 2023
* App Name: Astrological Zodiac Signs
* Description: This app will tell the user their astrological zodiac sign when they enter in their birthday.
*/

import java.util.Scanner;

public class AstrologicalZodiacSigns {

    // Constants
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";

    public static void main(String[] args) {

        // User input
        Scanner sc = new Scanner(System.in);

        // Variables
        int month = 0;
        int day = 0;
        boolean valid = false;
        int date = 0;

        // Set the title
        System.out.printf(SET_TITLE, "Astrological Zodiac Signs - Manu Sugunakumar");

        // Prints the banner and intro statement
        System.out.printf(Art.INPUT_BANNER);
        System.out.println("This program will tell your Astrological zodiac Sign based on your birthday!\n");

        // do while loop to loop app until user enters a valid input
        do {
            // Ask's the user for their birthday
            System.out.print("Enter your b-day (Month Day): ");
            
            // gets user input and trys to convert into integer variable type if unable will output valid as false
            try {
                month = sc.nextInt();
                day = sc.nextInt();
                valid = true;
            } catch (Exception exception) {
                valid = false;
            }

            sc.nextLine();// Clears the input

            valid = (month >= 1 && month <= 12) && (day >= 1 && day <= 31);// Checks if it is a valid month and day

            if (!valid) {
                System.out.println("Error - Input must be a valid month and day!");// outputs error statement if not valid
            } else {
                date = month * 100 + day;// Calculates the date

                // if and if else statments to print outputs
                if (date >= 321 && date <= 419) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER); // Clears terminal + adds banner
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.ARIES); // Calls from art class and prints the ascii art
                } else if (date >= 420 && date <= 520) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.TARUS);
                } else if (date >= 521 && date <= 620) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.GEMINI);
                } else if (date >= 621 && date <= 722) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.CANCER);
                } else if (date >= 723 && date <= 822) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.LEO);
                } else if (date >= 823 && date <= 922) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.VIRGO);
                } else if (date >= 923 && date <= 1022) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.LIBRA);
                } else if (date >= 1023 && date <= 1121) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.SCORPIUS);
                } else if (date >= 1122 && date <= 1221) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.SAGITTARIUS);
                } else if ((date >= 1222 && date <= 1231) || (date>= 100 && date <= 119)) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.CAPRICORN);
                } else if (date >= 120 && date <= 218) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.AQUARIUS);
                } else if (date >= 219 && date <= 320) {
                    System.out.printf(CLEAR_TERMINAL + Art.INPUT_BANNER);
                    System.out.printf("\nYour Astrological Zodiac Sign based on your birthday (%s/%s): \n\n", month, day);
                    System.out.printf(Art.PISCES);
                }
            }
        } while (!valid);

        // Exit prompt
        System.out.print("\nPress [Enter] to exit: ");
        sc.nextLine();
        sc.close();
    }
}