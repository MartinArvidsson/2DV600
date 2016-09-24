package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Car extends Vehicle
{
    protected Car(int passengers)
    {
        int maximumPassengers = 4;
        if(passengers <= maximumPassengers && passengers > 0)//Constuctor for creating a new Car if too many passengers are sent in throw exception instead
        {
            setSpace(1);
            setCostperP(15);
            setCostpervehicle(100);
            setNumberofPassengers(passengers);
            setVehicleType("Car");
        }
        else
        {
            throw new IndexOutOfBoundsException("Too many passengers in the car");
        }
    }
}
