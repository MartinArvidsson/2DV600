package ma223ku_assign2.Exercise_5;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Martin on 2016-09-21.
 */
public class WordCount2Main
{
    private static String _filepath = "", wordToAdd = "", textcontent ="";
    private static Character currentCharacter;
    private static HashWordSet _hashWordSet = new HashWordSet();
    private static TreeWordSet _treeWordSet = new TreeWordSet();

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

        for (int i = 0; i < textcontent.length(); i++) //Takes the entire textfile as a string, when the program encounters a whitespace it sens the previous
        {                                              //characters as a word to the tree/hash and clears the string. Repeat until the entire textfile has been looped.
            currentCharacter = textcontent.charAt(i);
            if(Character.isWhitespace(currentCharacter))
            {
                Word _word = new Word(wordToAdd);
                _treeWordSet.add(_word);
                _hashWordSet.add(_word);
                wordToAdd = "";
            }
            else if(!Character.isWhitespace(currentCharacter))
            {
                wordToAdd += currentCharacter;
            }
        }
        Word _word = new Word(wordToAdd);
        _hashWordSet.add(_word);
    }

    public static void print()
    {
        System.out.println(_treeWordSet.toString());
        System.out.println(_hashWordSet.toString());
        System.out.println(_treeWordSet.size());
        System.out.println(_hashWordSet.size());
    }
}
