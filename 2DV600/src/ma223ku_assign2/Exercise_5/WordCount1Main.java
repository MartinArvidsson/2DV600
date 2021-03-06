package ma223ku_assign2.Exercise_5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Martin on 2016-09-21.
 */
public class WordCount1Main
{
    private static HashSet<Word> _hashset = new HashSet<>();
    private static TreeSet<Word> _treeset = new TreeSet<>();
    private static String _filepath = "", wordToAdd = "", textcontent ="";
    private static Character currentCharacter;

    public static void main(String[] args)
    {
        try
        {
            if (args[0] != null)//Add path in program arguments
            {
                _filepath = args[0];
                readFile();
                print();
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

        for (int i = 0; i < textcontent.length(); i++) //Same functionality as the WordCountMain2
        {
            currentCharacter = textcontent.charAt(i);
            if(Character.isWhitespace(currentCharacter))
            {
                Word _word = new Word(wordToAdd);
                _hashset.add(_word);
                _treeset.add(_word);
                wordToAdd = "";
            }
            else if(!Character.isWhitespace(currentCharacter))
            {
                wordToAdd += currentCharacter;
            }
        }
        Word _word = new Word(wordToAdd);
    }

    public static void print()
    {
        Iterator<Word> iterator = _treeset.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println(_treeset.size());
        System.out.println(_hashset.size());
    }

}
