package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-16.
 */
public class FerrySimulation
{
    public static void main(String[] args)
    {
        //Class for testing the ferrysystem. Creates a new instance of Ferry and embark one of each vehicle. Then prints information about the Ferry
        Ferry ferry = new Ferry();

        try
        {
            ferry.embark(new Bicycle(1));
            ferry.embark(new Bus(10));
            ferry.embark(new Car(3));
            ferry.embark(new Lorry(2));
            System.out.println(ferry.toString());
        }
        catch (Exception e)
        {
            System.err.print(e.getMessage());
        }

    }
}
