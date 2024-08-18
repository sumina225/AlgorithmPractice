import java.io.*;
import java.util.*;

public class Solution {
	public static int[][] nums;
	public static int max;
	public static int maxLen;
	public static boolean[][] visited;
	public static int n;
	public static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test_case; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			nums = new int[n][n];
			visited = new boolean[n][n];
			max = 0;
			maxLen = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, nums[i][j]);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (nums[i][j] == max) {
						visited[i][j] = true;
						DFS(j, i, max, 1, 1);
						visited[i][j] = false;
					}
				}
			}
			System.out.println("#" + t + " " + maxLen);

		}
	}

	public static void DFS(int x, int y, int height, int len, int cnt) {
		maxLen = Math.max(len, maxLen);
		
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx]) {
				if (height <= nums[ny][nx]) {
					if (cnt == 1 && height > nums[ny][nx] - k) {
						int temp = 0;
						for (int j = 1; j <= k; j++) {
							if (nums[ny][nx] - j < height) {
								temp = nums[ny][nx] - j;
								break;
							}
						}
						visited[ny][nx] = true;
						DFS(nx,ny,temp,len+1,cnt-1);
						visited[ny][nx] = false;
					}
				}
				else {
					visited[ny][nx] = true;
					DFS(nx,ny,nums[ny][nx],len+1,cnt);
					visited[ny][nx] = false;
				}
			}
		}
	}

}
