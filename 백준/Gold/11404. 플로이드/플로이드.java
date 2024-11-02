
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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] nums = new int[n][n];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			if(nums[a][b] == 0) {
				nums[a][b] = weight;
			}else {
				nums[a][b] = Math.min(nums[a][b], weight);
			}
		}
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(nums[i][k] != 0 && nums[k][j] != 0) {
						if(i == j)continue;
						if(nums[i][j] == 0) {
							nums[i][j] = nums[i][k] + nums[k][j];
						}else {
							nums[i][j] = Math.min(nums[i][j], nums[i][k] + nums[k][j]);
						}
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(nums[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}