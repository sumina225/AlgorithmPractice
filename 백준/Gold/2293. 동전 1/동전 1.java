import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;

        // 동전을 먼저 순회 (i: 동전 인덱스)
        for(int i = 0; i < n; i++){
            // 각 동전에 대해 금액을 순회 (j: 금액)
            for(int j = nums[i]; j <= k; j++){
                dp[j] += dp[j-nums[i]];
            }
        }

        System.out.println(dp[k]);
    }
}