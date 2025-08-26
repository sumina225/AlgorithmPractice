import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][3];
        for(int i = 1; i < n+1; i++){
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
            dp[i][1] = dp[i-1][0] + num[i];
            dp[i][2] = dp[i-1][1] + num[i];
        }
        int answer = 0;
        for(int i = 0; i < 3; i++){
           if(answer < dp[n][i]) answer = dp[n][i];
        }
        System.out.println(answer);
    }
}
