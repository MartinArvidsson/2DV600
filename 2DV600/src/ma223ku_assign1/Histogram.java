package ma223ku_assign1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by marti on 2016-09-08.
 */
public class Histogram
{
    static Scanner _scanner;
    static private String _filepath;

    static private int onetohundred,hundredplus,currentnumber;

    static private String one = "",ten = "",twenty = "",thirty = "",forthy = "",fifthy = "",sixthy = "",seventy = "",eighty = "",ninty = "",hundred = "";

    public static void main(String[] args)
    {
        try
        {
            if(args[0].toString() != null)
            {
                _filepath = args[0];
            }
            else
            {
                throw new IllegalArgumentException();
            }
            File file = new File(_filepath);
            _scanner = new Scanner(file);
            while(_scanner.hasNext())
            {
                if(_scanner.hasNextInt())
                {
                    currentnumber = _scanner.nextInt();
                    System.out.println(currentnumber);
                    if(currentnumber > 1 && currentnumber < 11)
                    {
                        one +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 10 && currentnumber < 21)
                    {
                        ten +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 20 && currentnumber < 31)
                    {
                        twenty +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 30 && currentnumber < 41)
                    {
                        thirty +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 40 && currentnumber < 51)
                    {
                        forthy +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 50 && currentnumber < 61)
                    {
                        fifthy +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 60 && currentnumber < 71)
                    {
                        sixthy +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 70 && currentnumber < 81)
                    {
                        seventy +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 80 && currentnumber < 91)
                    {
                        eighty +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 90 && currentnumber < 101)
                    {
                        ninty +="*";
                        onetohundred += 1;
                    }
                    else if(currentnumber > 100 && currentnumber < 201)
                    {
                        hundred +="*";
                        hundredplus += 1;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong :(");
        }

        System.out.println("Number of integers in the interval [1,100]: " + onetohundred);
        System.out.println("Number of integers in the interval [101,200]: " + hundredplus);
        System.out.println("Histogram");
        System.out.println(" 1  - 10        | " + one);
        System.out.println(" 11  - 20       | " + ten);
        System.out.println(" 21  - 30       | " + twenty);
        System.out.println(" 31  - 40       | " + thirty);
        System.out.println(" 41  - 50       | " + forthy);
        System.out.println(" 51  - 60       | " + fifthy);
        System.out.println(" 61  - 70       | " + sixthy);
        System.out.println(" 71  - 80       | " + seventy);
        System.out.println(" 81  - 90       | " + eighty);
        System.out.println(" 91  - 100      | " + ninty);
        System.out.println(" 101  - 200     | " + hundred);

    }
}
