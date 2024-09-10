import java.io.*;
import java.util.*;

public class Main {

	static class Turn {
		int x;
		char c;

		public Turn(int x, char c) {
			super();
			this.x = x;
			this.c = c;
		}

	}

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] nums = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			nums[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 }; // 우하좌상
		int l = Integer.parseInt(br.readLine());
		Queue<Turn> turn = new LinkedList<>();

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			turn.add(new Turn(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}

		int[][] map = new int[n][n];
		map[0][0] = 0;
		int time = 0;
		int dir = 0;
		Pos nowPos = new Pos(0, 0);
		Pos tailPos = new Pos(0,0);
		while (true) {
			time++;	
			int ny = nowPos.y + dy[dir];
			int nx = nowPos.x + dx[dir];

			if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
				break;
			} else if (map[ny][nx] != 0) {
				break;
			} else {
				nowPos.x = nx;
				nowPos.y = ny;
			}

			if (nums[ny][nx] == 0) {
				map[ny][nx] = time;
				cute :for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(map[i][j] == map[tailPos.y][tailPos.x]+1) {
							map[tailPos.y][tailPos.x]= 0;
							tailPos.y = i;
							tailPos.x = j;
							break cute;
						}
					}
				}
			} else {
				map[ny][nx] = time;
				nums[ny][nx] = 0;
			}
			if (!turn.isEmpty()) {
				if (turn.peek().x == time) {
					if (turn.peek().c == 'D') {
						dir = (dir + 1) % 4;
					} else {
						dir = (dir + 3) % 4;
					}
					turn.poll();
				}
			}
						
		}
		System.out.println(time);

	}
}
