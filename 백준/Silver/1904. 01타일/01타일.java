import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 1 / 00 11 / 001 111 100
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[n]);
    }
}