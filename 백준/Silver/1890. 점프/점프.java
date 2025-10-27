import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP로 경로 개수 계산
        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] == 0 || nums[i][j] == 0) continue;

                int jump = nums[i][j];

                // 아래로 이동
                if(i + jump < n){
                    dp[i + jump][j] += dp[i][j];
                }

                // 오른쪽으로 이동
                if(j + jump < n){
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}