import java.io.*;
import java.util.*;

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static boolean[][] visited;
	public static int n;
	public static int m;
	public static int[][] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] nums = new int[n][m];
		temp = new int[n][m];
		for(int i =0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(nums[i][j] != 0) continue;
				for(int k = 0; k < n; k++) {
					for(int l = 0; l < m; l++) {
						if(k == i && l == j) continue;
						if(nums[k][l] != 0) continue;
						for(int o = 0; o < n; o++) {
							for(int p = 0; p < m; p++) {
								if((o == i && p == j) || (o == k && p == l)) continue; 
								if(nums[o][p] != 0) continue;
								for(int q = 0; q < n; q++) {
									temp[q] = Arrays.copyOf(nums[q], m);
								}
								temp[i][j] = 1;
								temp[k][l] = 1;
								temp[o][p] = 1;
								visited = new boolean[n][m];
								func();
								int count = 0;
								for(int q = 0; q < n; q++) {
									for(int r = 0; r < m; r++) {
										if(temp[q][r] == 0) {
											count++;
										}
									}
								}
								if(max < count) max = count;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
		
	}
	public static void func() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && temp[i][j] == 2) {
					Deque<Pos> deque = new ArrayDeque<>();
					deque.add(new Pos(j,i));
					visited[i][j] = true;
					while(!deque.isEmpty()) {
						Pos tem = deque.poll();
						int[] dx = {-1,1,0,0};
						int[] dy = {0,0,-1,1};
						for(int k = 0; k < 4; k++) {
							int nx = tem.x + dx[k];
							int ny = tem.y + dy[k];
							if(nx >= 0 && ny >= 0 && nx < m && ny < n &&!visited[ny][nx] && temp[ny][nx] != 1) {
								temp[ny][nx] = 2;
								visited[ny][nx] = true;
								deque.add(new Pos(nx,ny));
							}
						}
					}
				}
			}
		}
	}
}