import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[] nums = {1, 2, 3};
        long[] dp = new long[max + 1];
        dp[0] = 1; // 아무것도 안 더한 경우

        for (int num : nums) {      // 순서를 고정
            for (int i = num; i <= max; i++) {
                dp[i] += dp[i - num];
            }
        }

        for (int n : arr) {
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
