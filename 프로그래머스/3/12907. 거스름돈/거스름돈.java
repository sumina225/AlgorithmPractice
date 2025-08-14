import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int solution(int n, int[] money) {
        Arrays.sort(money);             // 조합 중복 방지를 위해 정렬(반드시 필요)
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int c : money) {
            if (c > n) break;
            for (int s = c; s <= n; s++) {
                dp[s] += dp[s - c];
                if (dp[s] >= MOD) dp[s] -= MOD; // dp[s] < 2*MOD 보장 → 1번 감산
            }
        }
        return dp[n];
    }
}
