import java.io.*;
import java.util.*;

public class Main{
	static class Water{
		int start;
		int end;
		public Water(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		List<Water> waters = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			waters.add(new Water(a,b));
		}
		Collections.sort(waters, new Comparator<Water>() {
			@Override
			public int compare(Water a, Water b) {
				return Integer.compare(a.start, b.start);
			}
		});
		int count = 0;
		int pos = 0;
		for(Water w : waters) {
			if(pos < w.start) {
				pos = w.start;
			}
			if(pos > w.end) continue;
			int cnt = 0;
			cnt = (w.end-pos) / l;
			cnt += (w.end-pos) % l == 0 ? 0 : 1;
			count += cnt;
			pos = pos + cnt*l;
		}
		System.out.println(count);
	}
}