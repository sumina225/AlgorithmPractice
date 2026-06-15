import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a >= b){
            sb.append(1);
        }else {
            sb.append(0);
        }
        sb.append("\n");

        if(a > b){
            sb.append(1);
        }else {
            sb.append(0);
        }
        sb.append("\n");

        if(a <= b){
            sb.append(1);
        }else {
            sb.append(0);
        }
        sb.append("\n");

        if(a < b){
            sb.append(1);
        }else {
            sb.append(0);
        }
        sb.append("\n");

        if(a == b){
            sb.append(1);
        }else {
            sb.append(0);
        }
        sb.append("\n");

        if(a != b){
            sb.append(1);
        }else {
            sb.append(0);
        }
        
        System.out.println(sb.toString());
    }
}