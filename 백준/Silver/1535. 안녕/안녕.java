import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] L = new int[n];
        int[] J = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101]; // dp[j] = 체력 j일 때 얻을 수 있는 최대 행복
        for (int i = 0; i < n; i++) {
            for (int j = 100; j >= L[i] + 1; j--) { // 역순으로 순회해야 중복 방지
                dp[j] = Math.max(dp[j], dp[j - L[i]] + J[i]);
            }
        }

        int answer = 0;
        for (int j = 1; j <= 100; j++) {
            answer = Math.max(answer, dp[j]);
        }

        System.out.println(answer);
    }
}
