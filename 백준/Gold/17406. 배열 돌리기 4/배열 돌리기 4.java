import java.io.*;
import java.util.*;

public class Main {
	static int[][] nums; // 2D 배열
	static int k; // 회전 작업의 수
	static boolean[] visited; // 각 회전 작업의 방문 여부를 체크하는 배열
	static Turn[] turns; // 회전 작업을 저장하는 배열
	static int min = Integer.MAX_VALUE; // 최소 행 합을 저장하는 변수
	static int n; // 행의 수
	static int m; // 열의 수

	// 회전 작업을 나타내는 클래스
	static class Turn {
		int r, c, s;

		public Turn(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	// 좌표를 나타내는 클래스
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nums = new int[n][m];

		// 입력된 배열 초기화
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		turns = new Turn[k];

		// 회전 작업 입력 받기
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			turns[i] = new Turn(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		visited = new boolean[k];
		func(0); // 회전 작업의 모든 조합을 시도
		System.out.println(min); // 최소 행 합 출력
	}

	// 모든 회전 작업의 조합을 시도하는 함수
	public static void func(int depth) {
		if (depth == k) { // 모든 회전 작업을 적용했을 때
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum += nums[i][j]; // 행의 합 계산
				}
				min = Math.min(sum, min); // 최소 행 합 갱신
			}
			return;
		}

		// 모든 회전 작업을 순서대로 시도
		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int[][] temp = deepCopy(nums); // 배열의 상태를 깊은 복사
				turn(turns[i]); // 회전 작업 적용
				func(depth + 1); // 다음 깊이로 재귀 호출
				nums = temp; // 배열 상태 복원
				visited[i] = false;
			}
		}
	}

	// 주어진 회전 작업을 배열에 적용하는 함수
	public static void turn(Turn t) {
		int r = t.r - 1; // 행 인덱스 조정
		int c = t.c - 1; // 열 인덱스 조정
		int s = t.s; // 회전 반경

		for (int i = 1; i <= s; i++) {
			Deque<Integer> temp = new ArrayDeque<>(); // 회전할 값을 저장할 큐
			int startX = c - i; // 회전의 시작 x 좌표
			int startY = r - i; // 회전의 시작 y 좌표
			int endX = c + i; // 회전의 끝 x 좌표
			int endY = r + i; // 회전의 끝 y 좌표

			// 상단 행 값을 큐에 추가
			for (int x = startX; x < endX; x++) {
				temp.add(nums[startY][x]);
			}

			// 우측 열 값을 큐에 추가
			for (int y = startY; y < endY; y++) {
				temp.add(nums[y][endX]);
			}

			// 하단 행 값을 큐에 추가
			for (int x = endX; x > startX; x--) {
				temp.add(nums[endY][x]);
			}

			// 좌측 열 값을 큐에 추가
			for (int y = endY; y > startY; y--) {
				temp.add(nums[y][startX]);
			}

			temp.addFirst(temp.pollLast()); // 큐를 회전

			// 상단 행에 회전된 값 적용
			for (int x = startX; x < endX; x++) {
				nums[startY][x] = temp.poll();
			}

			// 우측 열에 회전된 값 적용
			for (int y = startY; y < endY; y++) {
				nums[y][endX] = temp.poll();
			}

			// 하단 행에 회전된 값 적용
			for (int x = endX; x > startX; x--) {
				nums[endY][x] = temp.poll();
			}

			// 좌측 열에 회전된 값 적용
			for (int y = endY; y > startY; y--) {
				nums[y][startX] = temp.poll();
			}
		}
	}

	// 배열을 깊은 복사하여 반환하는 함수
	public static int[][] deepCopy(int[][] array) {
		int[][] copy = new int[array.length][];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i].clone();
		}
		return copy;
	}
}
