package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Lorry extends Vehicle
{
    private int maximumPassengers = 2;
    public Lorry(int passengers)
    {
        if(passengers <= maximumPassengers && passengers > 0)
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
