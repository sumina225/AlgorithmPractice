import java.io.*;
import java.util.*;

public class Main {

    static class Pos{
        int r;
        int c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];
        for(int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.max(dp[i-1][j-1] + map[i][j],Math.max(dp[i][j-1] + map[i][j],dp[i-1][j] + map[i][j]));
            }
        }
        System.out.println(dp[n][m]);
    }
}
