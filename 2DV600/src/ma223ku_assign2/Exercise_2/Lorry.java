package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Lorry extends Vehicle
{
    protected Lorry(int passengers)
    {
        int maximumPassengers = 2;
        if(passengers <= maximumPassengers && passengers > 0) //Constuctor for creating a new lorry if too many passengers are sent in throw exception instead
        {
            setSpace(8);
            setCostperP(15);
            setCostpervehicle(300);
            setNumberofPassengers(passengers);
            setVehicleType("Lorry");
        }
        else
        {
            throw new IndexOutOfBoundsException("Too many passengers in the lorry");
        }
    }
}
