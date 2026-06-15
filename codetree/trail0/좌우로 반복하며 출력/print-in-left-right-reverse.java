import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                for(int j = 1; j <= n; j++){
                    sb.append(j);
                }
            } else {
                for(int j = n; j >= 1; j--){
                    sb.append(j);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}