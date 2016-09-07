package ma223ku_assign1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by marti on 2016-08-31.
 */
public class LargestK {

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        int userinput;
        int K = 0;
        int sumtocheck = 0;

        System.out.println("Enter a non negative number");

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
            {
                System.out.println("Not a number");
                scan.next();
            }
            catch(IllegalArgumentException e) //If the value was too low we catch the previously thrown issue and presents it's message.
            {
                System.out.println(e.getMessage());
            }
        }

        while(true)
        {
            K += 2;
            sumtocheck += K;
            if(sumtocheck >= userinput)
            {
                break;
            }
        }

        System.out.print("K is : " + K);

    }
}
