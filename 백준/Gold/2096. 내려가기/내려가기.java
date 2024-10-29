import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] resultmin;
	static int[][] resultmax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		resultmin = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				resultmin[i][j] = Integer.MAX_VALUE;
			}
		}

		resultmax = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				resultmax[i][j] = Integer.MIN_VALUE;
			}
		}
		for (int i = 0; i < 3; i++) {
			resultmin[0][i] = map[0][i];
			resultmax[0][i] = map[0][i];
		}

		for(int i = 1; i < n; i++) {
			resultmin[i][0] = map[i][0] + Math.min(resultmin[i-1][0], resultmin[i-1][1]);
			resultmin[i][1] = map[i][1] + Math.min(resultmin[i-1][0], Math.min(resultmin[i-1][1],resultmin[i-1][2]));
			resultmin[i][2] = map[i][2] + Math.min(resultmin[i-1][2], resultmin[i-1][1]);
			
			resultmax[i][0] = map[i][0] + Math.max(resultmax[i-1][0], resultmax[i-1][1]);
			resultmax[i][1] = map[i][1] + Math.max(resultmax[i-1][0], Math.max(resultmax[i-1][1],resultmax[i-1][2]));
			resultmax[i][2] = map[i][2] + Math.max(resultmax[i-1][2], resultmax[i-1][1]);
		}

		for (int i = 0; i < 3; i++) {
			min = Math.min(min, resultmin[n - 1][i]);
			max = Math.max(max, resultmax[n - 1][i]);
		}
		System.out.println(max + " " + min);
	}

	// 굳이 백트래킹을 왜했지
//	public static void findMin(int depth, int index) {
//		int start = 0;
//		int end = 0;
//		switch (index) {
//		case 0:
//			start = 0;
//			end = 1;
//			break;
//		case 1:
//			start = 0;
//			end = 2;
//		case 2:
//			start = 1;
//			end = 2;
//		}
//		for (int i = start; i <= end; i++) {
//			if (depth + 1 < n) {
//				if (resultmin[depth + 1][i] <= resultmin[depth][index] + map[depth + 1][i]) {
//					continue;
//				} else {
//					resultmin[depth + 1][i] = resultmin[depth][index] + map[depth + 1][i];
//					findMin(depth + 1, i);
//				}
//			}
//		}
//
//	}
//
//	public static void findMax(int depth, int index) {
//		int start = 0;
//		int end = 0;
//		switch (index) {
//		case 0:
//			start = 0;
//			end = 1;
//			break;
//		case 1:
//			start = 0;
//			end = 2;
//		case 2:
//			start = 1;
//			end = 2;
//		}
//
//		for (int i = start; i <= end; i++) {
//			if (depth + 1 < n) {
//				if (resultmax[depth + 1][i] >= resultmax[depth][index] + map[depth + 1][i]) {
//					continue;
//				} else {
//					resultmax[depth + 1][i] = resultmax[depth][index] + map[depth + 1][i];
//					findMax(depth + 1, i);
//				}
//			}
//		}
//	}
}
