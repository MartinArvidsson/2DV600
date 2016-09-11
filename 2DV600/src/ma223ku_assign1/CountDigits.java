package ma223ku_assign1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marti on 2016-09-01.
 */
public class CountDigits
{
    public static void main(String[] args)//Add path in program arguments
    {
        Scanner scan = new Scanner(System.in);
        int userinput;
        int separatednumber = 0;
        int numberofzeros = 0;
        int numberofeven = 0;
        int numberofodd = 0;
        int sumofnumbers = 0;

        System.out.println("Enter a number to be checked");
        while(true) //Checks for correct input from the user
        {
            try
            {
                userinput = scan.nextInt(); //Takes the value from the console and adds it to the integer

                if(userinput < 0) //If the value is too low we throw an illegalargument exception
                {
                    throw new IllegalArgumentException("value is too low");
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

        System.out.println("Number separated is : ");
        separatednumber = userinput;
        while(separatednumber > 0)
        {
            System.out.print(" " + separatednumber % 10);

            if(separatednumber % 10 == 0)
            {
                numberofzeros += 1;
            }
            sumofnumbers += (separatednumber % 10);

            if ( ((separatednumber % 10) & 1) == 0  && (separatednumber % 10 != 0))
            {
                numberofeven += 1;
            }
            else
            {
                numberofodd += 1;
            }

            separatednumber = separatednumber / 10;

        }

        System.out.println("\nZeros: " + numberofzeros);

        System.out.println("Even : " + numberofeven);

        System.out.println("Odd: " + numberofodd);

        System.out.println("Total sum : " + sumofnumbers);

    }
}
