
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge{
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		List<List<Edge>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b,1));
		}
		
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[x] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge edge1, Edge edge2) {
				return Integer.compare(edge1.weight, edge2.weight);
			}
		});
		
		pq.add(new Edge(x,0));
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			int currentNode = current.to;
			
			for(Edge edge : graph.get(currentNode)) {
				int nextNode = edge.to;
				int newDistance = distance[currentNode] + edge.weight;
				
				if(newDistance < distance[nextNode]) {
					distance[nextNode] = newDistance;
					pq.add(new Edge(nextNode, newDistance));
				}
			}
		}
		
		List<Integer> result = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(distance[i] == k) {
				result.add(i);
			}
		}
		
		if(result.isEmpty()) {
			System.out.println(-1);
		}else {
			for(int node : result) {
				System.out.println(node);
			}
		}
		
	}
}