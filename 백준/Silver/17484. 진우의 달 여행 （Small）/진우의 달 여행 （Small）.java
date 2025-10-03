import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] nums = new int[n][m];
        int[][][] dp = new int[n][m][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                dp[0][i][j] = nums[0][i];
            }
        }
        int[] dc = {-1,0,1};

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 3; k++){
                    int prevR = i-1;
                    int prevC = j - dc[k];
                    if(prevC < 0 || prevC >= m) continue;
                    for(int l = 0; l < 3; l++){
                        if(l == k) continue;
                        if (dp[prevR][prevC][l] != Integer.MAX_VALUE) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[prevR][prevC][l] + nums[i][j]);
                        }
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                answer = Math.min(answer, dp[n-1][i][j]);
            }
        }
        System.out.println(answer);
    }
}
