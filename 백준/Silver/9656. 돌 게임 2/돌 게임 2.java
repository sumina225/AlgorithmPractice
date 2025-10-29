import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 4];
        dp[1] = false; // 상근이 패
        dp[2] = true;  // 상근이 승
        dp[3] = false; // 상근이 패

        for (int i = 4; i <= N; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3];
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
