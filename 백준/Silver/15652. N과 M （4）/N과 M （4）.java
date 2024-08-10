import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static int n;
	public static int m;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];

		func(0);
		System.out.println(sb.toString());

	}

	public static void func(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if (k == 0) {
			for (int i = 1; i <= n; i++) {
				arr[k] = i;
				func(k + 1);
			}
		} else {
			for (int i = arr[k - 1]; i <= n; i++) {
				arr[k] = i;
				func(k + 1);
			}
		}
	}

}