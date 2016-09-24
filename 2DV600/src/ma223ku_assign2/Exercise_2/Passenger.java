package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Passenger
{
    private int passengerCost = 0;

    public Passenger() //Constructor for passenger. 20 is the default value for creating a passenger, price changes based on what vehicle the passenger is in.
    {
        passengerCost = 20;
    }

    public Passenger(int _cost)
    {
        passengerCost = _cost;
    }

    public int getPassengerCost()
    {
        return passengerCost;
    }
}
