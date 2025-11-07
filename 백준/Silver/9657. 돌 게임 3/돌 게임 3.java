import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n + 5];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;

        for(int i = 5; i <= n; i++){
            if(!dp[i-1] || !dp[i-3] || !dp[i-4]){
                dp[i] = true;
            }
        }
        if(dp[n]){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
