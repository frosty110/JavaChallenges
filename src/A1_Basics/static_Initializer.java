package A1_Basics;

import java.util.Scanner;

public class static_Initializer {

    static int H, B;
    static boolean flag = false;

//    Static initialization blocks are executed when the class is loaded, and you can initialize static variables in those blocks.
    static {
        Scanner scan = new Scanner(System.in);
        H = scan.nextInt();
        B = scan.nextInt();

        if (H <= 0 || B <= 0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else{
            flag = true;
        }
    }

    public static void main(String[] args) {
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }
}
