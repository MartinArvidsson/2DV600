package ma223ku_assign2.Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by marti on 2016-09-15.
 */
public class Ferry implements IFerry
{
    private int moneyEarned;
    private int maximumPassengers;
    private int maximumVehicles;
    private ArrayList<Passenger> totalpassengers;
    private ArrayList<Vehicle> totalVehicle;

    public int countPassengers()
    {
        return totalpassengers.size();
    }

    public int countVehicleSpace()
    {
        return 0;
    }

    public int countMoney()
    {
        return 0;
    }

    public void embark(Vehicle v)
    {

    }

    public void embark(Passenger p)
    {

    }

    public void disembark()
    {

    }

    public boolean hasSpaceFor(Vehicle v)
    {
        return true;
    }

    public boolean hasRoomFor(Passenger p)
    {
        return true;
    }

    public String toString()
    {
        return "Not yet implemented";
    }

    public Iterator<Vehicle> iterator()
    {
        return null;
    }
}
