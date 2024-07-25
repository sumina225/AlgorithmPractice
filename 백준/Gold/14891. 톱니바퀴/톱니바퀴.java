import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		List<Integer>[] list = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			list[i] = new ArrayList<>();
			for (int j = 0; j < s.length(); j++) {
				list[i].add(s.charAt(j) - '0');
			}
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; // 1번톱니바퀴면 0번인덱스 이니 -1을 해줌
			int b = Integer.parseInt(st.nextToken()); // 시계 : 1 , 반시계 :-1
			boolean[] check = new boolean[4];
			for (int j = 0; j < 3; j++) {
				check[j] = list[j].get(2) != list[j + 1].get(6);
			}
			if (b < 0) {
				int temp = list[a].remove(0);
				list[a].add(temp);
			}
			else {
				int temp = list[a].remove(7);
				list[a].add(0,temp);
			}
			int right = a + 1;
			int left = a - 1;
			int leftmove = -b;
			int rightmove = -b;
			while (true) {
				if (right >= 4 && left < 0)
					break;
				if (right < 4) {
					if (!check[right - 1])
						right = 5;
					else if (check[right - 1]) {
						switch (rightmove) {
						case -1:
							int temp = list[right].remove(0);
							list[right].add(temp);
							break;
						case 1:
							temp = list[right].remove(7);
							list[right].add(0, temp);
						}
						right++;
						rightmove = -rightmove;
					}
				}
				if (left >= 0) {
					if (!check[left])
						left = -1;
					else if (check[left]) {
						switch (leftmove) {
						case -1:
							int temp = list[left].remove(0);
							list[left].add(temp);
							break;
						case 1:
							temp = list[left].remove(7);
							list[left].add(0, temp);
						}
						left--;
						leftmove = -leftmove;
					}
				}

			}

		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (list[i].get(0) == 1) {
				sum += Math.pow(2, i);
			}
		}
		bw.write(sum + "");

		br.close();
		bw.flush();
		bw.close();

	}
}