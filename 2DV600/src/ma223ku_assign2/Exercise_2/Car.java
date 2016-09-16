package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Car extends Vehicle
{
    private int maximumPassengers = 4;
    public Car(int passengers)
    {
        if(passengers <= maximumPassengers && passengers > 0)
        {
            setSpace(1);
            setCostperP(15);
            setCostpervehicle(100);
            setNumberofPassengers(passengers);
            setVehicleType("Car");
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
}
