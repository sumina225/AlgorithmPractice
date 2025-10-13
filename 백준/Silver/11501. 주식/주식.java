import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] days = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                days[i] = Integer.parseInt(st.nextToken());
            }
            long total = 0;
            int max = days[n-1];
            for(int i = n-2; i >= 0; i--){
                if(days[i] > max){
                    max = days[i];
                }else{
                    total += max-days[i];
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb.toString());
    }
}
