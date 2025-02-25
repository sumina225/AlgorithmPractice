import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동굴 길이 (짝수)
        int H = Integer.parseInt(st.nextToken()); // 동굴 높이

        int[] bottom = new int[H + 1]; // 석순 개수 (아래에서 위로)
        int[] top = new int[H + 1];    // 종유석 개수 (위에서 아래로)

        // 입력 처리
        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        // 누적합 계산 (하단과 상단의 장애물 개수 구하기)
        for (int i = H - 1; i > 0; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        // 최소 충돌 지점 찾기
        int minObstacles = Integer.MAX_VALUE; // 최소 장애물 수
        int count = 0; // 최소 장애물 수를 가지는 구간 개수

        for (int i = 1; i <= H; i++) {
            int obstacles = bottom[i] + top[H - i + 1]; // i 높이에서 장애물 개수
            if (obstacles < minObstacles) {
                minObstacles = obstacles;
                count = 1;
            } else if (obstacles == minObstacles) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(minObstacles + " " + count);
    }
}