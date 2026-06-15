import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = n; i <= 100; i++){
            if(i >= 90){
                sb.append("A ");
            } else if(i >= 80 && i < 90){
                sb.append("B ");
            } else if(i >= 70 && i < 80){
                sb.append("C ");
            } else if(i >= 60 && i < 70){
                sb.append("D ");
            } else {
                sb.append("F ");
            }
        }
        System.out.println(sb.toString());
    }
}