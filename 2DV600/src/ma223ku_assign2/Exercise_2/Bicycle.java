package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Bicycle extends Vehicle
{
    protected Bicycle(int passengers) //Constuctor for creating a new Bike if too many passengers are sent in throw exception instead
    {
        int maximumPassengers = 1;
        if(passengers == maximumPassengers)
        {
            setSpace(0.2);
            setCostperP(0);
            setCostpervehicle(40);
            setNumberofPassengers(passengers);
            setVehicleType("Bicycle");
        }
        else
        {
            throw new IndexOutOfBoundsException("Too many passengers on the bicyle");
        }
    }
}
