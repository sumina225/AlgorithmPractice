import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[t];
        int max = 0;
        for(int i = 0; i < t; i++){
            nums[i] = Integer.parseInt(br.readLine());
            if(max < nums[i]) max = nums[i];
        }
        long[][] dp = new long[max+1][4];
        if(max <= 2){
            for(int i = 0; i < t; i++){
                sb.append(1).append("\n");
            }
            System.out.println(sb.toString());
            return;
        }
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i = 4; i <= max; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
        }
        for(int i = 0; i < t; i++){
            sb.append((dp[nums[i]][1]+dp[nums[i]][2]+dp[nums[i]][3]) % 1000000009).append("\n");
        }
        System.out.println(sb.toString());
    }
}
