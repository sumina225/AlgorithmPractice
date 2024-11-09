import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int x;
		int time;
		public Pos(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		PriorityQueue<Pos> queue = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos a, Pos b) {
				return Integer.compare(a.time, b.time);
			}
		});
		queue.add(new Pos(n,0));
		boolean[] visited = new boolean[100001];
		visited[n] = true;
		while(!queue.isEmpty()) {
			Pos temp = queue.poll();
			visited[temp.x] = true;
			if(temp.x == k) {
				System.out.println(temp.time);
				return;
			}
			if(temp.x*2 <= 100000 && temp.x < k && !visited[temp.x*2]) {
				queue.add(new Pos(temp.x*2,temp.time));
			}
			if(temp.x+1 <= 100000 && temp.x < k && !visited[temp.x+1]) {
				queue.add(new Pos(temp.x+1,temp.time+1));
			}
			if(temp.x-1 >= 0 && !visited[temp.x-1]) {
				queue.add(new Pos(temp.x-1,temp.time+1));
			}
		}
		
		
	}
}
