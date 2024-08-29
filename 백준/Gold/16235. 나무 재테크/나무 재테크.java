import java.io.*;
import java.util.*;

public class Main{
	public static int[][] nums;
	public static ArrayList<Integer>[][] trees;
	public static int[][]  energys;
	public static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		nums = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		energys = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				energys[i][j] = 5;
			}
		}
		trees = new ArrayList[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				trees[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			trees[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				for(int l = 0; l < n; l++) {
					Spring(j,l);
				}
			}
			
			for(int j = 0; j < n; j++) {
				for(int l = 0; l < n; l++) {
					Fall(j,l);
				}
			}
			
			for(int j = 0; j < n; j++) {
				for(int l = 0; l < n; l++) {
					energys[j][l] += nums[j][l];
				}
			}
			
		}
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j< n; j++) {
				result += trees[i][j].size();
			}
		}
		System.out.println(result);
		
		
	}
	
	public static void Spring(int r, int c) {
		if(!trees[r][c].isEmpty()) {
			Collections.sort(trees[r][c]);
			int plus = 0;
			for(int i = 0; i < trees[r][c].size(); i++) {
				if(energys[r][c] >= trees[r][c].get(i)) {
					energys[r][c] -= trees[r][c].get(i);
					trees[r][c].set(i, trees[r][c].get(i)+1);
				}else {
					plus += trees[r][c].get(i)/2;
					trees[r][c].remove(i);
					i--;
				}
			}
			energys[r][c] += plus;
		}
	}
	
	public static void Fall(int r, int c) {
		if(!trees[r][c].isEmpty()) {
			int[] dr = {-1,-1,-1,0,0,1,1,1};
			int[] dc = {-1,0,1,-1,1,-1,0,1};
			for(int i = 0; i < trees[r][c].size(); i++) {
				if(trees[r][c].get(i) % 5 == 0) {
					for(int j = 0; j < 8; j++) {
						int nr = r + dr[j];
						int nc = c + dc[j];
						if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
							trees[nr][nc].add(1);
						}
					}
				}
			}
		}
	}
}