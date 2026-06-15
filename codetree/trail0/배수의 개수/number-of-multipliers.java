import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count3 = 0;
        int count5 = 0;
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            if(num % 3 == 0){
                count3++;
            }
            if(num % 5 == 0){
                count5++;
            }
        }
        System.out.println(count3 + " " + count5);
    }
}