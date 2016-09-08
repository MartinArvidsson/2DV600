package ma223ku_assign1;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by marti on 2016-09-08.
 */
public class Histogram
{
    static String textcontent,_filepath;
    static char currentCharacter;

    static int onetohundred,hundredplus = 0;

    static String one,ten,twenty,thirty,forthy,fifthy,sixthy,seventy,eighty,ninty,hundred = "";

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
            textcontent = new String(Files.readAllBytes(Paths.get(_filepath)));

            for (int i = 0; i < textcontent.length(); i++)
            {
                currentCharacter = textcontent.charAt(i);
                if(Character.isDigit(currentCharacter))
                {
                    if(currentCharacter > 1 && currentCharacter < 11)
                    {
                        one +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 10 && currentCharacter < 21)
                    {
                        ten +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 20 && currentCharacter < 31)
                    {
                        twenty +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 30 && currentCharacter < 41)
                    {
                        thirty +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 40 && currentCharacter < 51)
                    {
                        forthy +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 50 && currentCharacter < 61)
                    {
                        fifthy +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 60 && currentCharacter < 71)
                    {
                        sixthy +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 70 && currentCharacter < 81)
                    {
                        seventy +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 80 && currentCharacter < 91)
                    {
                        eighty +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 90 && currentCharacter < 101)
                    {
                        ninty +="*";
                        onetohundred += 1;
                    }
                    else if(currentCharacter > 100 && currentCharacter < 201)
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
