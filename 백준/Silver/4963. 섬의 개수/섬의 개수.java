import java.io.*;
import java.util.*;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int dy[] = {-1,-1,-1,0,0,1,1,1};
		int dx[] = {-1,0,1,-1,1,-1,0,1};
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) return;
			int[][] islands = new int[h][w];
			int result = 0;
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					islands[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[][] visited = new boolean[h][w];
			Queue<Point> q = new LinkedList<>();
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(islands[i][j] == 1 && !visited[i][j]) {
						q.add(new Point(j,i));
						result++;
						visited[i][j] = true;
						while(!q.isEmpty()) {
							Point temp = q.poll();
							for(int k = 0; k < 8; k++) {
								int nx = temp.x+ dx[k];
								int ny = temp.y + dy[k];
								if(nx < w && nx >= 0 && ny < h && ny >= 0 && !visited[ny][nx] && islands[ny][nx] == 1) {
									q.add(new Point(nx,ny));
									visited[ny][nx] = true;
								}
							}
						}
					}
				}
			}
			System.out.println(result);
		}
	}
}