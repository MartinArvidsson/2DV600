package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Passenger
{
    private int passengerCost = 0;

    public Passenger()
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
