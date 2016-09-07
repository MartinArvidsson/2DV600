package ma223ku_assign1;

import java.util.Scanner;

public class Backwards {

    public static void main(String[] args) {
	// write your code here
        Scanner userreader = new Scanner(System.in);
        String userinput = "";

        System.out.println("Write the string that will be presented in reverse order");
        userinput = userreader.nextLine();
        System.out.println("you wrote: " + userinput);
        System.out.println("reversed this becomes: " + new StringBuilder(userinput).reverse().toString());
    }
}
