import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		for(long i = Math.max(a, b); i <= a*b; i += Math.max(a, b)) {
			if(i % a == 0 && i % b == 0) {
				bw.write(i + "");
				break;
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}