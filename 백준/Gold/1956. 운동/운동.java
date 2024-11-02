
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
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] nums = new int[v][v];
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			nums[a][b] = weight;
		}
		
		for(int k = 0; k < v; k++) {
			for(int i = 0; i < v; i++) {
				for(int j = 0; j < v; j++) {
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
		int len = -1;
		for(int i = 0; i < v; i++) {
			if(nums[i][i] != 0) {
				if(len == -1) {
					len = nums[i][i];
				}else {
					len = Math.min(len, nums[i][i]);
				}
			}
		}
		System.out.println(len);
		
		
	}
}