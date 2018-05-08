package A1_Basics;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class end_of_file {
    public static void main(String[] args) {

        System.setIn(new ByteArrayInputStream("Hello world\nI am a file\nRead me until end-of-file.".getBytes()));
        solution();
    }

    public static void solution(){
        Scanner scan = new Scanner(System.in);
        int lineCounter = 1;
        while(scan.hasNext()){
            System.out.printf("%d %s\n", lineCounter, scan.nextLine());
            lineCounter ++;
        }
    }
}
