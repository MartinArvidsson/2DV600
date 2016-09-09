package ma223ku_assign1;


import java.io.File;
import java.util.Scanner;

/**
 * Created by Martin on 2016-09-08.
 */
public class CountJava
{
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
            printfilepath(_filepath);
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong :(");
        }
    }

    static void printfilepath(String _path)
    {
        try
        {
            _file = new File(_path);
            filedirectory = _file.listFiles();
            for (File path : filedirectory)
            {
                if (path.getName().toLowerCase().endsWith(".java"))
                {
                    Scanner _scanner = new Scanner(path);
                    while (_scanner.hasNextLine())
                    {
                        filelines++;
                        _scanner.nextLine();
                    }
                    i++;
                    System.out.println(i + " " + path + " \n Number of lines : " + filelines);
                    filelines = 0;
                }
                else if (path.isDirectory())
                {
                    printfilepath(path.getAbsolutePath());
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
    }
}
