import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test_case; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sb.append("#").append(t).append(" ");

			if ((Math.abs(x1 - x2) - Math.abs(y1 - y2)) % 2 == 0) {
				sb.append(Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)) * 2);
			} else {
				sb.append(Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)) * 2 - 1);
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
