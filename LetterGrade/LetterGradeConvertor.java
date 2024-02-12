/*
* Name: Manu Sugunakumar
* Date: Feburary 22, 2023
* App Name: Letter Grader
* Description: App that takes a grade as a percentage then outputs a converted letter grade with a feedback statement.
*/

import java.util.Scanner;

public class LetterGradeConvertor {
    // Constants
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";

    // Banner
    static final String BANNER = """
            ==========================
            = Letter Grade Converter =
            ==========================
            """;

    public static void main(String[] args) {
        // user input
        Scanner scanner = new Scanner(System.in);

        // Variables
        String restart = ""; // restart checker variable
        boolean valid = false; // valid checker
        Float numberGrade = 0f; // user grade number
        String letterGrade = ""; // converted grade
        String letterFeedback = ""; // feedback

        // Loop to keep user in aslong as they enter r at the end
        do {
            // Input screen and clears the terminal each loop
            System.out.printf(CLEAR_TERMINAL + BANNER);

            // Loop for error check
            do {
                System.out.print("Enter your grade percentage: ");

                // Tries to get a float from the user
                try {
                    numberGrade = scanner.nextFloat();
                    valid = true; // If pass sets valid to true
                } catch (Exception exception) {
                    valid = false; // if failed sets valid to false
                }

                // Ger rid of leftover input
                scanner.nextLine();

                // Checks if valid then outputs error statement
                if (!valid)
                    System.out.println("Error - Grade percentage must be numeric!"); // Outputs error statement
                else 
                {
                    // Checks if the grade is within range
                    if (Grade.gradeConvertor(numberGrade).equals("Error")) {
                        System.out.println("Error - Grade percentage must be between 0 and 100 percent!"); // Outputs error statement
                        valid = false; // Sets valid to false so it doesn't exit the loop
                    } 
                    else // Sets the variables to the converted grade and feedback if everything is correct
                    {
                        letterGrade = Grade.gradeConvertor(numberGrade); // Calls the grade convertor method from grade class
                        letterFeedback = Grade.gradeFeedback(letterGrade); // Calls the grade feedback method from grade class
                    }
                }
            } while (!valid);

            // Output screen and clears the terminal each loop
            System.out.printf(CLEAR_TERMINAL + BANNER);

            // Prints the output message
            System.out.printf("A grade of %s%% is equivalent %s which is considered \"%s\"!", numberGrade, letterGrade, letterFeedback);

            // Restart prompt
            System.out.print("\nEnter 'r' to restart: ");
            restart = scanner.nextLine();
        } while (restart.equals("r"));
        // Closes the scanner
        scanner.close();
    }
}