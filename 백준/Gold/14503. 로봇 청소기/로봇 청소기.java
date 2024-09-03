import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] nums;

	static class Pos {
		int x, y, d;

		public Pos(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		Pos robot = new Pos(x,y,dir);
		nums = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 1;
		boolean[][] visited = new boolean[n][m];
		cute: while (true) {
			visited[robot.y][robot.x] = true;
			for (int i = 1; i <= 4; i++) {
				int ny = robot.y + dy[(4 + robot.d - i) % 4];
				int nx = robot.x + dx[(4 + robot.d - i) % 4];
				if (nums[ny][nx] == 0 && !visited[ny][nx]) {
					count++;
					robot = new Pos(nx, ny, (4 + robot.d - i) % 4);
					continue cute;
				}
			}
			int ny = robot.y - dy[robot.d];
			int nx = robot.x - dx[robot.d];
			if (nums[ny][nx] == 1) {
				break;
			} else {
				robot = new Pos(nx, ny, robot.d);
			}
		}
		System.out.println(count);
	}
}