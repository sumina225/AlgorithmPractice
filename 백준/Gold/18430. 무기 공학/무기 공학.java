import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int[][] nums;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][m];

		func(0, 0, 0);
		System.out.println(max);

	}

	public static void func(int r, int c, int sum) {
		if (r == n) {
			max = Math.max(max, sum);
			return;
		}
		if (c == m) {
			func(r + 1, 0, sum);
			return;
		}

		if (!visited[r][c]) {
			if (r + 1 < n && c - 1 >= 0 && !visited[r + 1][c] && !visited[r][c - 1]) {
				visited[r][c] = true;
				visited[r + 1][c] = true;
				visited[r][c - 1] = true;
				func(r, c+1, sum + nums[r][c] * 2 + nums[r + 1][c] + nums[r][c - 1]);
				visited[r][c] = false;
				visited[r + 1][c] = false;
				visited[r][c - 1] = false;
			}
			if (r - 1 >= 0 && c - 1 >= 0 && !visited[r - 1][c] && !visited[r][c - 1]) {
				visited[r][c] = true;
				visited[r - 1][c] = true;
				visited[r][c - 1] = true;
				func(r, c+1, sum + nums[r][c] * 2 + nums[r - 1][c] + nums[r][c - 1]);
				visited[r][c] = false;
				visited[r - 1][c] = false;
				visited[r][c - 1] = false;
			}

			if (r - 1 >= 0 && c + 1 < m && !visited[r - 1][c] && !visited[r][c + 1]) {
				visited[r][c] = true;
				visited[r - 1][c] = true;
				visited[r][c + 1] = true;
				func(r, c+1, sum + nums[r][c] * 2 + nums[r - 1][c] + nums[r][c + 1]);
				visited[r][c] = false;
				visited[r - 1][c] = false;
				visited[r][c + 1] = false;
			}

			if (r + 1 < n && c + 1 < m && !visited[r + 1][c] && !visited[r][c + 1]) {
				visited[r][c] = true;
				visited[r + 1][c] = true;
				visited[r][c + 1] = true;
				func(r, c+1, sum + nums[r][c] * 2 + nums[r + 1][c] + nums[r][c + 1]);
				visited[r][c] = false;
				visited[r + 1][c] = false;
				visited[r][c + 1] = false;
			}

		}
		func(r,c+1,sum);

	}
}
