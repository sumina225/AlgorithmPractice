import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][land[0].length];
        dp[0] = land[0];
        for(int i = 1; i < land.length; i++){
            dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2],dp[i-1][3]));
            dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2],dp[i-1][3]));
            dp[i][2] = land[i][2] + Math.max(dp[i-1][1], Math.max(dp[i-1][0],dp[i-1][3]));
            dp[i][3] = land[i][3] + Math.max(dp[i-1][1], Math.max(dp[i-1][2],dp[i-1][0]));
        }
        answer = Math.max(Math.max(dp[land.length-1][0],dp[land.length-1][1]),Math.max(dp[land.length-1][2],dp[land.length-1][3]));
        
        return answer;
    }
}