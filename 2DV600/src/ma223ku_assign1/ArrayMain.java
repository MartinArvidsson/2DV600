package ma223ku_assign1;

/**
 * Created by Martin on 2016-09-07.
 */
public class ArrayMain
{
    public static void main(String[] args)
    {
        //Tester för Arrays.java.
        int[] sumarray = {1,2,3,4};
        int[] tostringarray = {1,2,3,4,5};
        int[] addNarray = {1,2,3,4,5};
        int Ntoadd = 2;
        int[] reversearray = {4,3,2,1};
        int[] replacearray = {1,2,3,7,5};
        int oldnumber = 7;
        int newnumber = 4;
        int[] sortarray = {1,8,6,2};
        int[] hassubarray = {1,2,3,4,5};
        int[] subarraytocheck = {3,4,5};
        int[] _subarraytocheck = {3,6,5};
        int[] absdiffarray1 = {1,2,3,4,5};
        int[] absdiffarray2 = {2,7,2,6,1};

        //SUM TEST
        System.out.println("Array not summarised : " + Arrays.toString(sumarray));
        System.out.println("Array summarised     : " + Arrays.sum(sumarray));
        System.out.println("----------------------------------------------------");

        //TO STRING TEST
        System.out.println("Array not to string : " + tostringarray);
        System.out.println("Array to string     : " + Arrays.toString(tostringarray));
        System.out.println("----------------------------------------------------");

        //ADD NUMBER TEST
        System.out.println("Numbers not added to array: " + Arrays.toString(addNarray));
        System.out.println("Number to add to array    : " + Ntoadd);
        System.out.println("Array to string           : " + Arrays.toString(Arrays.addN(addNarray,Ntoadd)));
        System.out.println("----------------------------------------------------");

        //REVERSE ARRAY TEST
        System.out.println("Array non reverse: " + Arrays.toString(reversearray));
        System.out.println("Array reversed   : " + Arrays.toString(Arrays.reverse(reversearray)));
        System.out.println("----------------------------------------------------");

        //REPLACE ALL TEST
        System.out.println("Non replaced     : " + Arrays.toString(replacearray));
        System.out.println("Number to replace: " + oldnumber + " New number: "+ newnumber);
        Arrays.replaceAll(replacearray,oldnumber,newnumber);
        System.out.println("Replaced numbers : " + Arrays.toString(replacearray));
        System.out.println("----------------------------------------------------");

        //SORT TEST
        System.out.println("Testarray unsorted: " + Arrays.toString(sortarray));
        System.out.println("Testarray sorted  : " + Arrays.toString(Arrays.sort(sortarray)));
        System.out.println("----------------------------------------------------");

        //SUBSEQUENCE TEST
        System.out.println("Primary array: " + Arrays.toString(hassubarray));
        System.out.println("Subarray     : " + Arrays.toString(subarraytocheck));
        System.out.println("Was the subarray found in the primary array? " + Arrays.hasSubsequence(hassubarray,subarraytocheck));
        System.out.println("----------------------------------------------------");

        //SUBSEQUENCE TEST 2
        System.out.println("Primary array: " + Arrays.toString(hassubarray));
        System.out.println("Subarray     : " + Arrays.toString(_subarraytocheck));
        System.out.println("Was the subarray found in the primary array? " + Arrays.hasSubsequence(hassubarray,_subarraytocheck));
        System.out.println("----------------------------------------------------");

        //ABSDIF TEST
        System.out.println("First array  : " + Arrays.toString(absdiffarray1));
        System.out.println("Second array : " + Arrays.toString(absdiffarray2));
        System.out.println("Absdiff array: " + Arrays.toString(Arrays.absDif(absdiffarray1,absdiffarray2)));
        System.out.println("----------------------------------------------------");

    }
}
