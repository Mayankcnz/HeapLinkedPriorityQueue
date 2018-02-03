
/**
 * Write a description of class Cyclist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyclist
{
    private String Number;
    private boolean available;
    private int nextAvailable;// da

    /**
     * Constructor for objects of class Cyclist
     */
    public Cyclist(String name, boolean availability)
    {
        Number = name;
        available = availability;
    }

    public boolean isAvailable(){
        return available;
    }

    public void set(boolean val){
        available = val;
    }

    public void setTime(int time){
        nextAvailable = time;
    }

    public int getNextAvailability() {
        return nextAvailable;
    }
}
