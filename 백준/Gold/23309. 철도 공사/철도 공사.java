import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] prev = new int[1000001];
		int[] next = new int[1000001];
		
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int last = first;
		for(int i = 1; i < n; i++) {
			int current = Integer.parseInt(st.nextToken());
			next[last] = current;
			prev[current] = last;
			last = current;
		}
		next[last] = first;
		prev[first] = last;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int I = Integer.parseInt(st.nextToken());
			switch(s) {
			case "BN":
				int J = Integer.parseInt(st.nextToken());
				int nextI = next[I];
				next[I] = J;
				prev[J] = I;
				if(nextI != 0) {
					next[J] = nextI;
					prev[nextI] = J;
				}
				sb.append(nextI).append("\n");
				break;
			case "BP":
				J = Integer.parseInt(st.nextToken());
				int prevI = prev[I];
				prev[I] = J;
				next[J] = I;
				if(prevI != 0) {
					prev[J] = prevI;
					next[prevI] = J;
				}
				sb.append(prevI).append("\n");
				break;
			case "CN" :
				nextI = next[I];
				next[I] = next[nextI];
				prev[next[I]] = I;
				sb.append(nextI).append("\n");
				break;
			case "CP":
				prevI = prev[I];
				prev[I] = prev[prevI];
				next[prev[I]] = I;
				sb.append(prevI).append("\n");
				break;
			}
		}
		System.out.println(sb);

	}
}
