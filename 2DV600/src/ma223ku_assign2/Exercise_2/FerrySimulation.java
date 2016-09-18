package ma223ku_assign2.Exercise_2;

/**
 * Created by Martin on 2016-09-16.
 */
public class FerrySimulation
{
    public static void main(String[] args)
    {
        Ferry ferry = new Ferry();


        //Add 3 of cars,Busses and Bicycles
        try
        {
            for (int i = 0; i < 10; i++)
            {
                ferry.embark(new Lorry(2));
                ferry.embark(new Bus(20));
            }
            System.out.println(ferry.toString());
        }
        catch (Exception e)
        {
            System.err.print(e.getMessage());
        }

    }
}
