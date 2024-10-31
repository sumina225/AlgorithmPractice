import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		int x;
		int y;
		int z;
		int time;

		public Pos(int x, int y, int z, int time) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][][] nums = new int[h][n][m];
		boolean[][][] visited = new boolean[h][n][m];
		Queue<Pos> queue = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					nums[i][j][k] = Integer.parseInt(st.nextToken());
					if (nums[i][j][k] == 1) {
						queue.add(new Pos(k, j, i, 0));
						visited[i][j][k] = true;
					}
				}
			}
		}

		int max = 0;
		// 방향벡터 생각하기
		int[] dz = { -1, 1, 0, 0, 0, 0};
		int[] dy = { 0, 0, -1, 1, 0, 0};
		int[] dx = { 0, 0, 0, 0, -1, 1};

		while (!queue.isEmpty()) {
			Pos temp = queue.poll();
			max = Math.max(max, temp.time);
			// bfs 마저 구현하기
			// nums도 1로바꾸기
			for(int i = 0; i < 6; i++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];
				int nz = temp.z + dz[i];
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h && !visited[nz][ny][nx] && nums[nz][ny][nx] == 0) {
					visited[nz][ny][nx] = true;
					nums[nz][ny][nx] = 1;
					queue.add(new Pos(nx,ny,nz,temp.time+1));
				}
			}
		}

		// 다 익었는지 체크하기
		boolean isAble = true;
		cute :for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if(nums[i][j][k] == 0) {
						isAble = false;
						break cute;
					}
				}
			}
		}
		if(isAble) {
			System.out.println(max);
		}else {
			System.out.println(-1);
		}

	}
}