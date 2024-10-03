import java.io.*;
import java.util.*;

public class Main {
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int n;
	static int m;
	static char[][] nums;
	static Pos start;

	static class Pos {
		int x;
		int y;

		public Pos(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				nums[i][j] = s.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		start = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

		int result = 0;
		char resDir = 'U';
		for (int i = 0; i < 4; i++) {
			int time = check(new Pos(start.y,start.x), i);
			if (result < time) {
				switch (i) {
				case 0:
					resDir = 'U';
					break;
				case 1:
					resDir = 'R';
					break;
				case 2:
					resDir = 'D';
					break;
				case 3:
					resDir = 'L';
					break;
				}
				result = time;
			}
		}
		System.out.println(resDir);
		if(result == Integer.MAX_VALUE) {
			System.out.println("Voyager");
		}else {
			System.out.println(result);
		}

	}

	static int check(Pos pos, int dir) {
		int t = 1;
		boolean[][][] visited = new boolean[n][m][4];
		while (true) {
			int x = pos.x + dx[dir];
			int y = pos.y + dy[dir];

			if (x < 0 || y < 0 || x >= m || y >= n || nums[y][x] == 'C') {
				return t;
			}
			if (visited[y][x][dir]) {
				return Integer.MAX_VALUE;
			}

			visited[y][x][dir] = true;

			if (nums[y][x] == '/') {
				switch (dir) {
				case 0:
					dir = 1;
					break;
				case 1:
					dir = 0;
					break;
				case 2:
					dir = 3;
					break;
				case 3:
					dir = 2;
					break;
				}
			} else if (nums[y][x] == '\\') {
				switch (dir) {
				case 0:
					dir = 3;
					break;
				case 1:
					dir = 2;
					break;
				case 2:
					dir = 1;
					break;
				case 3:
					dir = 0;
					break;
				}
			}
			t++;
			pos.y = y;
			pos.x = x;
		}
	}
}
