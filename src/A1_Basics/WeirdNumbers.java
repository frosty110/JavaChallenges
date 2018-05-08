package A1_Basics;

import java.util.Scanner;

public class WeirdNumbers {
    public static void main(String[] args){
    }

    public void javaInOut(){
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();

        if (value == 0)
            return;
        String printOut = "";

        if (value % 2 != 0) {
            printOut = "Weird";
        } else {
            if (value > 2 && value <= 5){
                printOut = "Not Weird";
            }
            else if (value > 6 && value <= 20){
                printOut = "Weird";
            }
            else if (value > 20){
                printOut = "Not Weird";
            }
        }
    }
    public void javaLoops(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int m;
        for (int i=1; i<=10; i++){
            m = i * N;
            System.out.printf("%d x %d = %d\n", N, i, m);
        }
    }
}
