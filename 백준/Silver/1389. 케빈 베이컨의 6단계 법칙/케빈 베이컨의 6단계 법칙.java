
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] nums = new int[n][n];
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				nums[i][j] = Integer.MAX_VALUE;
//			}
//		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			nums[a][b] = 1;
			nums[b][a] = 1;
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(nums[i][k] != 0 && nums[k][j] != 0) {
						if(nums[i][j] == 0) {
							nums[i][j] = nums[i][k] + nums[k][j];
						}else {
							nums[i][j] = Math.min(nums[i][j], nums[i][k] + nums[k][j]);
						}
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int minK = -1;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j< n; j++) {
				sum += nums[i][j];
			}
			if(sum < min) {
				min = sum;
				minK = i+1;
			}
		}
		System.out.println(minK);
		
		
	}
}