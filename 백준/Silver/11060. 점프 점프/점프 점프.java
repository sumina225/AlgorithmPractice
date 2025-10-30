import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == Integer.MAX_VALUE || nums[i] == 0) continue;
            for(int j = 1; j <= nums[i]; j++){
                if(i+j >= n) break;
                dp[i+j] = Math.min(dp[i+j],dp[i]+1);
            }
        }
        if(dp[n-1] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[n-1]);
        }

    }
}
