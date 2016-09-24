package ma223ku_assign2.Exercise_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2016-09-14.
 */
public class Vehicle //Set values based on what vehicle is being embarked.
{
    private double space;
    private int totalpassengers;
    private int costperpassenger;
    private int costpervehicle;
    private String typeofvehicle;
    private ArrayList<Passenger> passengersInVehicle = new ArrayList<>();

    void setSpace(double _space)
    {
        space = _space;
    }

    void setNumberofPassengers(int _totalpassengers)
    {
        totalpassengers = _totalpassengers;
    }

    void setCostperP(int _costperpassenger)
    {
        costperpassenger = _costperpassenger;
    }

    void setCostpervehicle(int _costpervehicle)
    {
        costpervehicle = _costpervehicle;
    }

    void setVehicleType(String _typeofvehicle)
    {
        typeofvehicle = _typeofvehicle;
    }

    List<Passenger> getPassengerList() //Returns a list of all passengers in a vehicle
    {
        passengersInVehicle.clear();
        for (int i = 0; i < getTotalpassengers(); i++)
        {
            passengersInVehicle.add(new Passenger(getCostperpassenger()));
        }
        return passengersInVehicle;
    }

    double getSpace()
    {
        return space;
    }

    int getTotalpassengers()
    {
        return totalpassengers;
    }

    int getCostperpassenger()
    {
        return costperpassenger;
    }

    int getCostpervehicle()
    {
        return costpervehicle;
    }

    String getTypeofvehicle()
    {
        return typeofvehicle;
    }
}
