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
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= k; i++){
            if(dp[i] == Integer.MAX_VALUE) continue;
            for(int j = 0; j < n; j++){
                if(i+nums[j] > k) continue;
                dp[i+nums[j]] = Math.min(dp[i+nums[j]],dp[i]+1);
            }
        }
        if(dp[k] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[k]);
        }

    }
}
