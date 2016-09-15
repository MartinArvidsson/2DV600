package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-14.
 */
public class Vehicle
{
    protected double space;
    protected int totalpassengers;
    protected int costperpassenger;
    protected int costpervehicle;
    protected String typeofvehicle;


    public void setSpace(double _space)
    {
        space = _space;
    }

    public void setNumberofPassengers(int _totalpassengers)
    {
        totalpassengers = _totalpassengers;
    }

    public void setCostperP(int _costperpassenger)
    {
        costperpassenger = _costperpassenger;
    }

    public void setCostpervehicle(int _costpervehicle)
    {
        costpervehicle = _costpervehicle;
    }

    public void setVehicleType(String _typeofvehicle)
    {
        typeofvehicle = _typeofvehicle;
    }

    public int getTotalpassengers()
    {
        return totalpassengers;
    }

    public int getCostperpassenger()
    {
        return costperpassenger;
    }

    public int getCostpervehicle()
    {
        return costpervehicle;
    }

    public String getTypeofvehicle()
    {
        return typeofvehicle;
    }
}
