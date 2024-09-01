import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] nums = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< n; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		int result = 0;
		while(true) {
			boolean[][] visited = new boolean[n][n];
			boolean isChanged = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j]) {
						List<Pos> temp = new ArrayList<>();
						int count = 0;
						int sum = 0;
						Queue<Pos> queue = new LinkedList<>();
						visited[i][j] = true;
						queue.add(new Pos(j,i));
						while(!queue.isEmpty()) {
							Pos tempPos = queue.poll();
							temp.add(tempPos);
							count++;
							sum += nums[tempPos.y][tempPos.x];
							for(int k = 0; k < 4; k++) {
								int nx = tempPos.x + dx[k];
								int ny = tempPos.y + dy[k];
								if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx] && Math.abs(nums[ny][nx] - nums[tempPos.y][tempPos.x]) >= l && Math.abs(nums[ny][nx] - nums[tempPos.y][tempPos.x]) <= r) {
									visited[ny][nx] = true;
									queue.add(new Pos(nx,ny));
									isChanged = true;
								}
							}
						}
						for(Pos pos : temp) {
							nums[pos.y][pos.x] = sum/count; 
						}
					}
				}
			}
			if(!isChanged) break;
			result++;
		}
		System.out.println(result);
	}
}