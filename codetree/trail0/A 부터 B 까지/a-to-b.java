import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while(a <= b){
            sb.append(a).append(" ");
            if(a % 2 == 0){
                a += 3;
            } else {
                a *= 2;
            }
        }
        System.out.println(sb);
    }
}