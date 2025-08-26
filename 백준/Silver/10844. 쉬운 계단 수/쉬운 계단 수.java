import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];
        for (int d = 1; d <= 9; d++) dp[1][d] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % MOD;
            for (int d = 1; d <= 8; d++) {
                dp[i][d] = (dp[i - 1][d - 1] + dp[i - 1][d + 1]) % MOD;
            }
            dp[i][9] = dp[i - 1][8] % MOD;
        }

        long ans = 0;
        for (int d = 0; d <= 9; d++) ans = (ans + dp[N][d]) % MOD;
        System.out.println(ans);
    }
}
