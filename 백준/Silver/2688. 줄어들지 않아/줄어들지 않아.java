import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 최대 n = 64
        long[][] dp = new long[65][10];

        // 초기값
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // DP 계산
        for (int i = 2; i <= 64; i++) {
            dp[i][0] = 1; // 항상 0만 오는 경우
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int j = 0; j <= 9; j++) {
                sum += dp[n][j];
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
