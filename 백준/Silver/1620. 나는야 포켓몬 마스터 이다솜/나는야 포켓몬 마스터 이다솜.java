import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		Map<String, Integer> hMap2 = new HashMap<String, Integer>();
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			hMap.put(i, s);
			hMap2.put(s, i);
		}
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
				bw.write(hMap.get(Integer.parseInt(s)) + "\n");
			}
			else {
				bw.write(hMap2.get(s) + "\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}