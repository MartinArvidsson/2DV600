package ma223ku_assign1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * Created by marti on 2016-09-06.
 */
public class CountChars
{
    static int upperCases;
    static int lowerCases;
    static int whitespaces;
    static int others;
    static int numbers;
    static char currentCharacter;
    static String _filepath = "";
    static String textcontent;


    public static void main(String[] args)
    {
        try
        {
            if(args[0].toString() != null)//Add path in program arguments
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

                if(Character.isUpperCase(currentCharacter))
                {
                    upperCases +=1;
                }
                else if(Character.isLowerCase(currentCharacter))
                {
                    lowerCases += 1;
                }
                else if(Character.isWhitespace(currentCharacter))
                {
                    whitespaces +=1;
                }
                else if(Character.isDigit(currentCharacter))
                {
                    numbers +=1;
                }
                else
                {
                    others +=1;
                }
            }

            System.out.print("Uppercases " + upperCases + "\n" + "Lowercases " + lowerCases + "\n" + "Whitespaces " + whitespaces +"\n"
            + "numbers " + numbers +"\n" + "other characters " + others);
        }
        catch(Exception e)
        {
            System.out.println("something went wrong with the application");
        }
    }
}
