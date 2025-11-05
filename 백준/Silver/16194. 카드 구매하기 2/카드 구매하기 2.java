import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n+1];
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for(int i = 1; i<= n; i++){
            dp[i] = nums[i];
        }

        for(int i = 2; i <= n; i++){
            for(int j = 1; i-j >= 1; j++){
                dp[i] = Math.min(dp[i], dp[j] + nums[i-j]);
            }
        }
        System.out.println(dp[n]);
    }
}
