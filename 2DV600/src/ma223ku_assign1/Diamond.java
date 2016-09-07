package ma223ku_assign1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marti on 2016-09-05.
 */
public class Diamond
{
    static Scanner scan = new Scanner(System.in);
    static int diamonwidth;
    static int currentwidth = 1;
    static int whitespace;
    static boolean pyramidtop = false;
    static boolean whitespaces = true;

    public static void main(String[] args)
    {
        getdiamondwidth();
        whitespace = (diamonwidth -1)/2;
        for (int y = 0; y < diamonwidth; y++)
        {
            for (int x = 0; x < whitespace; x++)
            {
                System.out.print(" ");
            }
            for (int _x = 0; _x < currentwidth; _x++)
            {
                System.out.print("*");
            }
            System.out.print("\n");

            if(currentwidth < diamonwidth && !pyramidtop)
            {
                currentwidth+=2;
            }
            else
            {
                currentwidth -=2;
                pyramidtop = true;
            }
            if(whitespace > 0 && whitespaces)
            {
                whitespace -=1;
            }
            else
            {
                whitespace+=1;
                whitespaces = false;
            }
        }

    }

    public static void getdiamondwidth()
    {
        while(true)
        {
            try
            {
                diamonwidth = scan.nextInt(); //Takes the value from the console and adds it to the integer

                if(diamonwidth < 1 || diamonwidth % 2 == 0 ) //If the value is too low we throw an illegalargument exception
                {
                    throw new IllegalArgumentException("value is too low or not odd");
                }
                else //If nothing is wrong we simply quit the loop
                    break;
            }
            catch (InputMismatchException e) //If  the scanner throws an error that the input doesn't match what
            //it's trying to add we catch the issue and give the user a new try
            //Can't take more than 10 characters?
            {
                System.out.println("Not a number");
                scan.next();
            }
            catch(IllegalArgumentException e) //If the value was too low we catch the previously thrown issue and presents it's message.
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
