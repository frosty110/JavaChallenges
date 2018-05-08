package A1_Basics;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class IntegerDataTypes {

    public static void main(String[] args) {

        System.setIn(new ByteArrayInputStream("5\n-150\n150000\n1500000000\n213333333333333333333333333333333333\n-100000000000000".getBytes()));
        Solution.solution();
    }

}

class Solution{
    public static void solution(){
        Scanner sc = new Scanner(System.in);

        /* Sample output values:
            5
            -150
            150000
            1500000000
            213333333333333333333333333333333333
            -100000000000000
         */
        int integer = sc.nextInt();

        System.out.println("integer = " + integer);

        for (int i =0; i<integer; i++){
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in: ");

                /*
                    A byte is an 8-bit signed integer.
                    A short is a 16-bit signed integer.
                    An int is a 32-bit signed integer.
                    A long is a 64-bit signed integer.
                 */
                if (x>=-Math.pow(2,7) && x<= Math.pow(2,7)-1){
                    System.out.println("* byte");
                }
                if (x>=-Math.pow(2,15) && x<= Math.pow(2,15)-1){
                    System.out.println("* short");
                }
                if (x>=-Math.pow(2,31) && x<= Math.pow(2,317)-1){
                    System.out.println("* int");
                }

                System.out.println("* long");


            } catch (Exception e){
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }

    }
}
