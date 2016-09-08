package ma223ku_assign1;


import java.io.File;
import java.util.Scanner;

/**
 * Created by Martin on 2016-09-08.
 */
public class CountJava
{
    static Scanner _scanner;
    static private String _filepath;
    static File[] filedirectory;
    static File _file;
    static int i,filelines;
    public static void main(String[] args)
    {
        try
        {
            if (args[0].toString() != null)
            {
                _filepath = args[0];
            }
            else
            {
                throw new IllegalArgumentException();
            }
            _file = new File(_filepath);
           filedirectory = _file.listFiles();
           for(File path:filedirectory)
           {
               _scanner = new Scanner(path);
               while(_scanner.hasNextLine())
               {
                   filelines ++;
                   _scanner.nextLine();
               }
               i++;
               System.out.println(i+" "+path +" \n Number of lines : " + filelines);
               filelines =0;
           }

        }
        catch (Exception e)
        {
            System.out.println("Something went wrong :(");
        }
    }
}
