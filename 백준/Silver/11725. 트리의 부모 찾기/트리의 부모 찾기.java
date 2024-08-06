import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] nums = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			nums[i] = new ArrayList<>();
		}
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nums[a].add(b);
			nums[b].add(a);
		}
		
		int[] result = new int[n+1];
		boolean[] visited = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			visited[temp] = true;
			for(int i = 0; i < nums[temp].size(); i++) {
				if(!visited[nums[temp].get(i)]) {
					queue.add(nums[temp].get(i));
					result[nums[temp].get(i)] = temp;
				}
			}
		}
		for(int i = 2; i <= n; i++) {
			System.out.println(result[i]);
		}
		
	}
}
