package ma223ku_assign2.Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by marti on 2016-09-15.
 */
public class Ferry implements IFerry
{
    private int moneyEarned = 0;
    private int maximumPassengers = 200;
    private int maximumVehicleSpace = 40;
    private int currentSpace;
    private ArrayList<Passenger> totalpassengers;
    private ArrayList<Vehicle> totalVehicle;
    private List<Passenger> _passengers;

    public Ferry()
    {
        totalpassengers = new ArrayList<>();
        totalVehicle = new ArrayList<>();
    }

    public int countPassengers()
    {

        return totalpassengers.size();
    }

    public int countVehicleSpace()
    {
        return currentSpace;
    }

    public int countMoney()
    {
        return moneyEarned;
    }

    public void embark(Vehicle v)
    {
        if(!totalVehicle.contains(v) && Math.ceil(currentSpace + v.getSpace()) <= maximumVehicleSpace)
        {
            totalVehicle.add(v);
            currentSpace += v.getSpace();
            moneyEarned += v.getCostpervehicle();
            v.passengerlist();
            _passengers = v.getPassengerList();
            for (int i = 0; i < _passengers.size(); i++)
            {
                embark(_passengers.get(i));
            }
        }
    }

    public void embark(Passenger p)
    {
        if(!totalpassengers.contains(p))
        {
            totalpassengers.add(p);
        }
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
