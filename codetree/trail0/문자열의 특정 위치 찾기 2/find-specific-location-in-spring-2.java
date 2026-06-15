import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        char c = br.readLine().charAt(0);
        String[] ss = {"apple", "banana", "grape", "blueberry", "orange"};
        int count = 0;
        for(int i = 0; i < 5; i++){
            if(c == ss[i].charAt(2) || c == ss[i].charAt(3)){
                sb.append(ss[i]).append("\n");
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
    }
}