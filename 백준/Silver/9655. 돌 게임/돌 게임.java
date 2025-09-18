import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n+1];
        if(n == 1){
            System.out.println("SK");
            return;
        }else if(n == 2){
            System.out.println("CY");
            return;
        }else if(n == 3){
            System.out.println("SK");
            return;
        }
        dp[1] = true;
        dp[2] = false;

        dp[3] = true;
        for(int i = 4; i <= n; i++){
            if(!dp[i-1] || !dp[i-3]){
                dp[i] = true;
            }else{
                dp[i] = false;
            }
        }
        if(dp[n]){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}