import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long dp[] = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 1000001; i++){
            dp[i] = (dp[i-3] + dp[i-2] +dp[i-1]) % 1000000009;
        }
        for(int tc = 1; tc <= t; tc++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] % 1000000009).append("\n");
        }
        System.out.println(sb.toString());
    }
}
