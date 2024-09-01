import java.io.*;
import java.util.*;

public class Main{
	
	public static int V;
	public static int[] parents;
	
	public static void make() {
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = -1;
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static class Edge{
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

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[E];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edges,new Comparator<Edge>() {
			@Override
			public int compare(Edge a, Edge b) {
				return Integer.compare(a.weight, b.weight);
			}
		});
		make();
		int cnt = 0;
		int cost = 0;
		for(Edge e : edges) {
			if(union(e.start,e.end)) {
				cost+= e.weight;
				cnt++;
				if(cnt == V-1) break;
			}
		}
		System.out.println(cost);
		
	}
	
}