import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int paircount = Integer.parseInt(br.readLine());
		List<List<Integer>> pair = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			pair.add(new ArrayList<>());
		}
		
		for(int i = 0; i < paircount; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pair.get(a).add(b);
			pair.get(b).add(a);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		queue.add(1);
		visited[1] = true;
		int result = 0;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			result++;
			
			for(int i : pair.get(current)) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		bw.write(result -1 + "");
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
