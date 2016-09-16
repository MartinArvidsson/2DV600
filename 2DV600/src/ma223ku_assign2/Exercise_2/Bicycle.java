package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Bicycle extends Vehicle
{
    int maximumPassengers = 1;
    public Bicycle(int passengers)
    {
        if(passengers <= maximumPassengers && passengers > 0)
        {
            setSpace(0.2);
            setCostperP(0);
            setCostpervehicle(40);
            setNumberofPassengers(passengers);
            setVehicleType("Bicycle");
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
}
