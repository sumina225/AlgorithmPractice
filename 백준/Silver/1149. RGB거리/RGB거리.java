import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] nums = new int[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] result = new int[n][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				result[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 0; i < 3; i++) {
			result[0][i] = nums[0][i];
		}
		for(int i = 1; i < n; i++) {
			result[i][0] = nums[i][0] + Math.min(result[i-1][1], result[i-1][2]);
			result[i][1] = nums[i][1] + Math.min(result[i-1][0], result[i-1][2]);
			result[i][2] = nums[i][2] + Math.min(result[i-1][0], result[i-1][1]);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, result[n-1][i]);
		}
		System.out.println(min);
	}
}