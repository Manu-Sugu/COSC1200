/*
* Name: Manu Sugunakumar
* Date: March 29, 2023
* App Name: Presto Simulator
* Description: This app will simulate a real life presto machine.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class PrestoSimulator
{
    // Constants
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static final int ONE_SECOND = 1000;
    static final double FARE = 2.50;

    // Banner
    static final String BANNER = """
        _____   _____     _____   _____   _____   _____      _____       ___   _____    _____
        | _  \\  |  _ \\   | ____| / ___/  |_   _| /  _  \\    / ___|      /   | | _   \\  |  _  \\
        | |_| | | |_| |  | |__   | |___    | |   | | | |    | |        / /| | | |_| |  | | | |
        | ___/  |  _ /   | __|   \\___ \\    | |   | | | |    | |       / / | | |  _  /  | | | |
        | |     | | \\ \\  | |___   ___| |   | |   | |_| |    | |___   / /  | | | | \\ \\  | |_| |
        |_|     |_|  \\_\\ |_____| /_____/   |_|   \\_____/    \\_____| /_/   |_| |_|  \\_\\ |_____/

        Program that simulates Presto Cards
            """;

    /** method that waits a second */
    static void waitAsec()
    {
        try
        {
            Thread.sleep(ONE_SECOND);
        }
        catch (Exception exception)
        {

        }
    }
    public static void main(String[] args) 
    {
        // User input
        Scanner scanner = new Scanner(System.in);
        
        // Create new array list of presto cards
        ArrayList<PrestoCard> cards = new ArrayList<PrestoCard>();
        cards.add(new PrestoCard("Alice", 1.05));
        cards.add(new PrestoCard("Manu", 5.10));
        cards.add(new PrestoCard("Fred", 25.00));

        // Set the title
        System.out.printf(SET_TITLE, "Presto Simulator - Manu Sugunakumar");

        // Variables
        boolean running = true;
        String command;
        String name;
        double balance = 0;
        boolean numeric = false;
        int index = 0;
        double funds = 0;
        String line = "-----------------";
        String historyBanner = "";

        do
        {
            // Clear the terminal and prints the banner
            System.out.printf(CLEAR_TERMINAL + BANNER);

            // Says how many cards we have
            System.out.println("We currently have " + cards.size() + " cards!\n");
            
            for(int count = 0; count < cards.size(); count++)
            {
                // Card Index - Card Name - Balance
                System.out.printf("%s - %s - $%.2f \n" ,count+1 ,cards.get(count).getName() ,cards.get(count).getBalance());
            }

            // Asks the user for a command
            System.out.print("\nEnter command: ");
            command = scanner.next().toLowerCase();

            // Quit the app command
            if(command.equals("quit"))
            {
                running = false;
                System.out.println("\nThank you! Come again!");
            }
            else if(command.equals("add"))
            {
                // prompt the user for the card name
                name = scanner.next();
                // in try catch to verify if the value for balance is numeric
                try 
                {
                    balance = scanner.nextDouble();
                    numeric = true;
                } 
                catch (Exception e) 
                {
                    numeric = false;
                }
                // Checks if card is numeric and greater than or equal to zero (you can not have a card start in the negative)
                if(!numeric || balance < 0) System.out.println("\nError - Invalid Balance! Balance must be a postive number!");
                else
                {
                    cards.add(new PrestoCard(name, balance));  // Otherwise add the new card using name and balance
                    System.out.println("The card was successfully added!");
                }
            }
            else if(command.equals("del"))
            {
                // Stores the name of the card in name
                name = scanner.next();
                // Checks if the card is in the system
                index = PrestoCard.searchName(cards, name);
                // Statement telling the user that there is no card under the name they inputted
                if(index == -1) System.out.println("\nSorry there was no card under " + name + ".");
                // if the system found the card then it will delete if from the system
                else
                {
                    System.out.println("\nThe card was found we will now delete it!");
                    cards.remove(index);
                }
            }
            else if(command.equals("tap"))
            {
                // Stores the name of the card in name
                name = scanner.next();
                // Checks if the card is in the list
                index = PrestoCard.searchName(cards, name);
                // Checking if the name matches a card in the system
                if(index == -1) System.out.println("\nSorry there was no card under " + name + ".");
                else
                {
                    // Checking if the card has enough balance to tap up
                    if(cards.get(index).tap(FARE) == false) System.out.println("\nSorry this card does not have enough funds to tap.");
                    // if it is not false then it is true which means that it was tapped
                    else System.out.println("\nCard successfully tapped!");
                }
            }
            else if(command.equals("topup"))
            {                
                // Stores the name of the card in name
                name = scanner.next();
                try 
                {
                    funds = scanner.nextDouble();
                    numeric = true;
                } 
                catch (Exception e) 
                {
                    numeric = false;
                }
                // Checks if the card is in the list
                index = PrestoCard.searchName(cards, name);
                // Checking if the name matches a card in the system
                if(index == -1) System.out.println("\nSorry there was no card under " + name + ".");
                else
                {
                    if(numeric == false || funds < 0) System.out.println("\nError - The funds to add must be a postive number!");
                    else 
                    {
                        cards.get(index).topUp(funds);
                        System.out.println("\nCard successfully topped up!");
                    }
                }
            }else if(command.equals("history"))
            {
                // Stores the name of the card in name
                name = scanner.next();
                // Checks if the card is in the list
                index = PrestoCard.searchName(cards, name);
                // Checking if the name matches a card in the system
                if(index == -1) System.out.println("\nSorry there was no card under " + name + ".");
                else{            
                    // Add one '-' for each letter in the name
                    // Before loop ; condition to loop ; after each iteration;
                    for (int count = 0; count < name.length(); count++) {
                        line += '-'; // Adds 1 '=' to the line
                    }
            
                    historyBanner = line + "\n- " + name + " Card History -\n" + line;
                    // Prints the banner for the history
                    System.out.println(CLEAR_TERMINAL + historyBanner);
                    cards.get(index).printHistory();
                    System.out.print("\nPress [Enter] to return to Main Menu: ");
                    scanner.nextLine();
                }
            }
            else System.out.println("\nError - Invalid command!");

            // get rid of any leftover input
            scanner.nextLine();

            waitAsec();
        }while(running);

        // Close the scanner
        scanner.close();
    }
}