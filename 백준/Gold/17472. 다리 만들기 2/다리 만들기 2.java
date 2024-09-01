import java.io.*;
import java.util.*;

public class Main {
	static int[][] nums;
	static int n;
	static int m;
	static List<Edge> edges = new ArrayList<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] parents;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Edge {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

	}

	public static void make() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = -1;
		}
	}

	public static int findSet(int a) {
		if (parents[a] < 0)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int bRoot = findSet(b);
		int aRoot = findSet(a);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

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
		boolean[][] visited = new boolean[n][m];
		int islandCount = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nums[i][j] != 0 && !visited[i][j]) {
					Queue<Pos> queue = new LinkedList<>();
					queue.add(new Pos(j, i));
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						Pos temp = queue.poll();
						nums[temp.y][temp.x] = islandCount;
						for (int k = 0; k < 4; k++) {
							int ny = temp.y + dy[k];
							int nx = temp.x + dx[k];
							if (ny >= 0 && nx >= 0 && ny < n && nx < m && nums[ny][nx] != 0 && !visited[ny][nx]) {
								nums[ny][nx] = islandCount;
								visited[ny][nx] = true;
								queue.add(new Pos(nx, ny));
							}
						}

					}
					islandCount++;
				}
			}
		}
		parents = new int[islandCount];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nums[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						func(nums[i][j], j, i, 0, k);
					}
				}
			}
		}
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge a, Edge b) {
				return Integer.compare(a.weight, b.weight);
			}
		});
		make();
		int cnt = 0;
		int cost = 0;
		for (Edge edge : edges) {
			if (union(edge.start, edge.end)) {
				cnt++;
				cost += edge.weight;
				if (cnt == islandCount - 2)
					break;
			}
		}
		if (cnt != islandCount-2) {
			cost = -1;
		}
		System.out.println(cost);

	}

	public static void func(int start, int x, int y, int count, int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
			if (nums[ny][nx] == start)
				return;
			else if (nums[ny][nx] != start && nums[ny][nx] != 0) {
				if (count >= 2) {
					edges.add(new Edge(Math.min(start, nums[ny][nx]), Math.max(start, nums[ny][nx]), count));
				}
				return;
			} else if (nums[ny][nx] == 0) {
				func(start, nx, ny, count + 1, dir);
			}
		}
	}

}