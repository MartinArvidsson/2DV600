package ma223ku_assign2.Exercise_5;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by marti on 2016-09-21.
 */
public class IndentifyWordsMain
{
    static String _filepath = "";
    static String textcontent = "";
    static String newTextfile ="";
    static char currentCharacter;

    public static void main(String[] args)
    {
        try
        {
            if (args[0].toString() != null)//Add path in program arguments
            {
                _filepath = args[0];
                readFile();
                createFile();
            } else
            {
                throw new IndexOutOfBoundsException();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readFile()
    {
        try
        {
            textcontent = new String(Files.readAllBytes(Paths.get(_filepath)));
        }
        catch ( Exception e)
        {
           e.printStackTrace();
        }

        for (int i = 0; i < textcontent.length(); i++)
        {
            currentCharacter = textcontent.charAt(i);
            if(Character.isWhitespace(currentCharacter) || Character.isLetter(currentCharacter))
            {
                newTextfile += currentCharacter;
            }
        }
    }

    public static void createFile()
    {
        try
        {
            PrintWriter writer = new PrintWriter("Words.txt", "UTF-8");
            writer.print(newTextfile);
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
