import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        // dp[i] = i를 제곱수의 합으로 나타내는 최소 개수
        int[] dp = new int[n + 1];

        // 초기화 (최댓값으로)
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // 각 수에 대해 최소 개수 계산
        for (int i = 1; i <= n; i++) {
            // i보다 작거나 같은 모든 제곱수에 대해
            for (int j = 1; j * j <= i; j++) {
                // i에서 j²를 뺀 나머지에 1을 더한 값과 비교
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}