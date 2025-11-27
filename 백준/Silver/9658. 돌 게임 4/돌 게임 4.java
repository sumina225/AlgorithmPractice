import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n+1];
        if (n >= 1) dp[1] = false;
        if (n >= 2) dp[2] = true;
        if (n >= 3) dp[3] = false;
        if (n >= 4) dp[4] = true;
        // dp[5] = false; dp[6] = true;
        for(int i = 5; i <= n; i++){
            dp[i] = false;
            if(!dp[i-1]) dp[i] = true;
            else if(!dp[i-3]) dp[i] = true;
            else if(!dp[i-4]) dp[i] = true;
        }
        System.out.println(dp[n] ? "SK" : "CY");
    }
}