package ma223ku_assign1;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 * Created by marti on 2016-09-01.
 */
public class HighLow
{
    static Scanner scan = new Scanner(System.in);
    static int randomnumber;
    static int playerguess;
    static int playerattempts;
    static Random rand = new Random();

    public static void main(String[] args)
    {

        System.out.println("Guess the number between 1 - 100, 10 attempts!");

        randomnumber = rand.nextInt(100+1);
        while(true)
        {

            if (playerattempts <= 10) {
                getplayerguess();
                if(playerguess < randomnumber)
                {
                    System.out.println("too low");
                }
                if(playerguess > randomnumber)
                {
                    System.out.println("too high");
                }
                if(playerguess == randomnumber)
                {
                    System.out.println("you won");
                    break;
                }
            }
        }



    }

    public static void getplayerguess()
    {
        while(true)
        {
            try
            {
                playerguess = scan.nextInt(); //Takes the value from the console and adds it to the integer

                if(playerguess < 1) //If the value is too low we throw an illegalargument exception
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
    }
}
