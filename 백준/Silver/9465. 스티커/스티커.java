import java.io.*;
import java.util.*;

public class Main {
	static int r;
	static int c;
	static int t;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] nums = new int[2][n];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[n][3];
			dp[0][0] = nums[0][0];
			dp[0][1] = nums[1][0];
			dp[0][2] = 0;
			for(int i = 1; i < n; i++) {
				dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2])+nums[0][i];
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2])+nums[1][i];
				dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]),dp[i-1][2]);
			}
			int max = 0;
			for(int i = 0; i <= 2; i++) {
				max = Math.max(max, dp[n-1][i]);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
	}
}
