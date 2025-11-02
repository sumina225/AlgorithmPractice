import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k+1][n+1];
        for(int i = 0; i <= n; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) dp[i][j] = 1;
                else dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.println(dp[k][n]);
    }
}
