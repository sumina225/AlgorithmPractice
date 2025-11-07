import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] nums = new double[n];
        double[] dp = new double[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = nums[0];
        double answer = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.printf("%.3f", answer);
    }
}
