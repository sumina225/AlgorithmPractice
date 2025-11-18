import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] dp = new int[y+1];
        dp[0] = h;
        for(int i = 1; i <= y; i++){
            dp[i] = Math.max((int)(dp[i-1]*1.05),dp[i]);
            if(i-3 >= 0){
                dp[i] = Math.max((int)(dp[i-3]*1.2),dp[i]);
            }
            if(i-5 >= 0){
                dp[i] = Math.max((int)(dp[i-5]*1.35),dp[i]);
            }
        }
        System.out.println(dp[y]);

    }
}
