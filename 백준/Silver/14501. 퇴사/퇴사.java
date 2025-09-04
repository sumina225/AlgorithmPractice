import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] ts = new int[n];
        int[] ps = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            ts[i] = Integer.parseInt(st.nextToken());
            ps[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; i--){
            if(i + ts[i] <= n){
                dp[i] = Math.max(ps[i] + dp[i+ts[i]],dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }
        System.out.println(dp[0]);
    }
}

