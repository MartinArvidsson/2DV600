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
    @Override
    public int countPassengers()
    {

        return totalpassengers.size();
    }
    @Override
    public int countVehicleSpace()
    {
        return currentSpace;
    }
    @Override
    public int countMoney()
    {
        return moneyEarned;
    }
    @Override
    public void embark(Vehicle v)
    {
        if(!totalVehicle.contains(v) && hasSpaceFor(v))
        {
            _passengers = v.getPassengerList();
            totalVehicle.add(v);
            currentSpace += v.getSpace();
            moneyEarned += v.getCostpervehicle();

            for (int i = 0; i < _passengers.size(); i++)
            {
                embark(_passengers.get(i));
            }
        }
    }
    @Override
    public void embark(Passenger p)
    {
        if(!totalpassengers.contains(p))
        {
            totalpassengers.add(p);
            moneyEarned += p.getPassengerCost();
        }
    }
    @Override
    public void disembark()
    {
        totalVehicle.clear();
        totalpassengers.clear();
    }
    @Override
    public boolean hasSpaceFor(Vehicle v)
    {
        if(Math.ceil(currentSpace + v.getSpace()) <= maximumVehicleSpace && totalpassengers.size() + v.getPassengerList().size() < maximumPassengers)
        {
            return true;
        }
        return false;
    }
    @Override
    public boolean hasRoomFor(Passenger p)
    {
        if((totalpassengers.size() + 1) <= maximumPassengers)
        {
            maximumPassengers +=1 ;
            return true;
        }
        return false;

    }

    @Override
    public String toString()
    {
        Iterator<Vehicle> iterator = totalVehicle.iterator();
        String ferryInformation = "Ferry: " +
                "\n Current Passengers : " + totalpassengers.size() + " of : " + maximumPassengers +
                "\n Current Vehiclespace : " + totalVehicle.size() + " of : " + maximumVehicleSpace +
                "\n Money earned : " + moneyEarned + " kr. \n\n" +
                "Information about all vehicles \n";
        while (iterator.hasNext())
        {
            Vehicle _v = iterator.next();
            ferryInformation += "Type : " + _v.getTypeofvehicle() + "\n" +
                    "Space taken : " + _v.getSpace() + "\n" +
                    "Passengers in Vehicle : " + _v.getTotalpassengers() + "\n" +
                    "Passenger cost : " + _v.getCostperpassenger() + "\n";
        }

        return ferryInformation;
    }
    @Override
    public Iterator<Vehicle> iterator()
    {
        return new Iterator<Vehicle>()
        {
            private int vehicleCount = 0;
            @Override
            public boolean hasNext()
            {
                return vehicleCount < totalVehicle.size();
            }

            @Override
            public Vehicle next()
            {
                return totalVehicle.get(vehicleCount++);
            }
        };
    }
}
