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
        for (int i = 0; i < 3; i++)
        {
            ferry.embark(new Car(1));
//            ferry.embark(new Bicycle(1));
//            ferry.embark(new Bus(20));
        }

        System.out.println(ferry.toString());
    }
}