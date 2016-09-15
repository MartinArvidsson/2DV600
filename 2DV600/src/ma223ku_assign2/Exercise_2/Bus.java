package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Bus extends Vehicle
{
    private int maximumPassengers = 20;
    public Bus(int passengers)
    {
        if(passengers <= maximumPassengers)
        {
            setSpace(4);
            setCostperP(10);
            setCostpervehicle(200);
            setNumberofPassengers(passengers);
            setVehicleType("Bus");
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
}
