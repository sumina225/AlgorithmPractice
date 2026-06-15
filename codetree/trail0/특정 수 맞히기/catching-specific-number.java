import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num < 25){
                sb.append("Higher").append("\n");
            }else if(num > 25){
                sb.append("Lower").append("\n");
            } else {
                sb.append("Good");
                break;
            }
        }
        System.out.println(sb);
    }
}