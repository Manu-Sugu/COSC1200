/*
 * Name: Manu Sugunakumar
 * Date: March 10, 2023
 * App Name: Horse Race
 * Description: This app will simulate a race horse using classes, objects, and arrays.
 */
import java.util.Scanner;

public class HorseRace
{
    // enum - enumeration → sequence of enumerated constants
    enum Colour
    {
        // 0    1     2       3     4       5       6     7
        BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, GREY;
        /** Dark version of the colour **/
        int dark()
        {
            return ordinal() + 30;
        }
        /** Bright version of the colour **/
        int bright()
        {
            return ordinal() + 90;
        }
    };
    // Constants
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static final int HALF_SECOND = 500;
    static final String SET_COLOUR = "\033[%sm";
    
    // Banner
    static final String BANNER = """
            ~~~~~~~~~~~~~~~
            ~ Horse Race! ~
            ~~~~~~~~~~~~~~~
            """;

    // Methods
    /**
     * Stop code execution for half a second
     */
    static public void waitHalfSecond()
    {
        // uses try catch because the .sleep command can generate an exception
        try 
        {
            // .sleep makes the app pause for half a second to
            Thread.sleep(HALF_SECOND);
        } catch (Exception exception) 
        {
            
        }
    }

    /**
     * Draws the lines for the horses
     * @param horse Get's the horse
     */
    static public void drawDistanceLine(Horse horse)
    {
        // for loop counts the number of dots needed to be printed
        for(int countDots = 0; countDots < horse.getDistanceCovered(); countDots++)
        {
            System.out.print(".");
        }
    }
    
    /**
     * Reset all colours to their default values 
     */
    static void resetColur()
    {
        System.out.printf(SET_COLOUR, 0);
    }

    /**
     * Change the font colour
     * @param foreground Font colour
     */
    static void setColour(int foreground)
    {
        System.out.printf(SET_COLOUR, foreground);
    }

    /**
     * Print a coloured message ending with a new line
     * @param message Text message
     * @param foreground Text colour
     */
    static void print(String message, int foreground)
    {
        setColour(foreground);
        System.out.println(message);
        resetColur();
    }

    public static void main(String[] args) 
    {
        // User input
        Scanner scanner = new Scanner(System.in);
        
        // Variables
        Boolean noWinners = true;

        // Set title
        System.out.printf(SET_TITLE, "Horse Race - Manu Sugunakumar");
        
        // Create the horse objects in an array
        Horse[] horses = {
            new Horse("Nae Nae"),
            new Horse("Tae Tae"),
            new Horse("Hae Hae"),
            new Horse("Cray Cray"),
            new Horse("José")
        };

        // Keep racing while there is no winner, stop racing once a horse wins
        while(noWinners)
        {
            // Print banner
            System.out.printf(CLEAR_TERMINAL + BANNER);

            // print top border
            print("\n==================================", Colour.CYAN.bright());
            // For loop to make all the horses run and draw their lines
            for(int index = 0; index < horses.length; index++)
            {
                // Makes the horses start running
                horses[index].run();
                
                // Checks if a horse has won or not otherwise it will keep the horses running
                if(horses[index].getDistanceCovered() == 20)
                {
                    // sets the colour of the horse that won to green
                    setColour(Colour.GREEN.bright());
                    // prints the line
                    drawDistanceLine(horses[index]);
                    // prints the horse's name on the same line
                    System.out.printf("%s", horses[index].getName());
                    // prints the win statement
                    System.out.print(" Wins!");
                    // resets the color so only the one line is colored
                    resetColur();
                    // sets nowinners to false so it can exit
                    noWinners = false;
                }
                else
                {
                    // draws the horse lines
                    drawDistanceLine(horses[index]);
                    System.out.printf("%s", horses[index].getName());
                }
                // prints new line for the horse to be drawn on
                System.out.println("");
            }

            // print top border
            print("==================================", Colour.CYAN.bright());
            waitHalfSecond();
        }

        // Exit prompt
        System.out.print("Press [Enter] to Exit: ");
        scanner.nextLine();
        scanner.close();
    }
}