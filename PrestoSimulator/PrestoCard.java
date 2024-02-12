import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrestoCard {

    // Priavate Variables
    private double balance;
    private String name;
    private String history = "";

    // Setting the decimal format to two places
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    /**
     * The Constructor
     * @return An object
     */
    PrestoCard(String name, double balance)
    {
        // Intialize the class variables
        this.balance = balance;
        this.name = name;
    }

    // Getter methods

    /**@return the cards balance */
    public double getBalance() 
    {
        return balance;
    }

    /**@return the card holders name */
    public String getName() 
    {
        return name;
    }

    /**@return true if theres enough funds in the card and false if not */
    public boolean tap(double fare)
    {
        if(balance > fare) 
        {
            // if the card has enough in its balance it will be tapped
            balance -= fare;
            // Adding a new line to the history variable for that object
            history += "\ntap   - new balance: $" + decimalFormat.format(balance);
            return true;  // returns true to tell if tapped
        }
        // otherwise will return false to tell it was not tapped
        return false;
    }

    /** Adds the funds to the current cards balance */
    public void topUp(double funds)
    {
        // Adding the funds to the balance
        balance = balance + funds;
        // Adding a new line to the history variable for that object
        history += "\ntopup - new balance: $" + decimalFormat.format(balance);
    }

    /**
     * This method will take an array list of cards and name of a card then return the index
     * @param cards the array list
     * @param name the name of the card
     * @return the index
     */
    public static int searchName(ArrayList<PrestoCard> cards, String name)
    {
        for(int count = 0; count < cards.size(); count++)
        {
            // if the card name for that card is equal to the name of card in the system
            if(cards.get(count).getName().equals(name))
            {
                // return cards.size();
                return count;
            }
        }
        // otherwise return -1 to tell that there is no card under that name
        return -1;
    }

    /** Prints the history for that card */
    public void printHistory()
    {
        if(history.equals("")) System.out.println("\nNo History Available!");
        else System.out.println(history);
    }
}