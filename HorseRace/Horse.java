import java.util.Random;

public class Horse {
    // Constants
    private final int MIN_SPEED_INCREASE = 0;
    private final int MAX_SPEED_INCREASE = 2;

    // Class variables
    private String name;
    private int distanceCovered = 0;
    private Random random = new Random();  // Creates a new random

    /**
     * The constructor
     * @param name The name of the horse object
     * @return Returns a new horse object
     */
    Horse(String name)
    {
        this.name = name;
    }

    /**
     * Get's the name of the horse object
     * @return The horse's name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Get's the distance covered
     * @return The distance covered by the horse
     */
    public int getDistanceCovered() 
    {
        return distanceCovered;
    }
    /**
     * Get's a random int between MIN_SPEED_INCREASE and MAX_SPEED INCREASE and adds it to distancecovered
     */
    public void run()
    {
        distanceCovered += random.nextInt(MIN_SPEED_INCREASE, MAX_SPEED_INCREASE);
    }
}
