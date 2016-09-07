package ma223ku_assign1;

import java.security.InvalidParameterException;

/**
 * Created by marti on 2016-09-07.
 */
public class Arrays {

    public static int sum(int[] arr)
    {
        int arrsum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrsum += arr[i];
        }
        return arrsum;
    }

    public static String toString(int[] arr)
    {
        String arraycontent = "{";
        for (int i = 0; i < arr.length; i++) {
            arraycontent += arr[i]+", ";
        }
        arraycontent += "}";
        return arraycontent;
    }

    public static int[] addN(int[] arr, int n)
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] += 2;
        }
        return arr;
    }

    public static int[] reverse(int[] arr)
    {
        int[] reversedarray = new int[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            reversedarray[i] = arr[arr.length - (i+1)];
        }
        return reversedarray;
    }

    public static void replaceAll(int[] arr,int old, int nw)
    {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == old)
            {
                arr[i] = nw;
            }
        }
    }

    public static int[] sort(int[] arr)
    {
        int[] sortedarray;
        sortedarray = arr;
        java.util.Arrays.sort(sortedarray);

        return sortedarray;
    }

    public static boolean hasSubsequence(int[] arr,int[] sub)
    {
        try
        {
            if(sub.length > arr.length)
            {
                throw new IndexOutOfBoundsException();
            }
            else
            {
                for (int i = 0; i < arr.length; i++)
                {
                    if(arr[i] == sub[0])
                    {
                        for (int j = 0; j < sub.length; j++)
                        {
                            if(arr[i+j] != sub[j])
                            {
                                return  false;
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong! Sorry :(");
        }
        return true;
    }

    public static int[]absDif(int[] arr1,int[] arr2)
    {
        int[] diffArray = new int[arr1.length];
        try
        {
            if(arr1.length == arr2.length)
            {

                for (int i = 0; i < arr1.length; i++) {
                    diffArray[i] = Math.abs(arr1[i] - arr2[i]);
                }
            }
            else
            {
                throw new InvalidParameterException();
            }
        }
        catch(Exception e)
        {
            System.out.println("Something whent wrong with the application :(");
        }
        return diffArray;
    }
}
