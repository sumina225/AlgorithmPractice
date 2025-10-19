import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dist(Point other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] checkpoints = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkpoints[i] = new Point(x, y);
        }

        // 전체 거리 계산
        int totalDistance = 0;
        for (int i = 1; i < N; i++) {
            totalDistance += checkpoints[i - 1].dist(checkpoints[i]);
        }

        // 건너뛰었을 때 절약할 수 있는 최대 거리
        int maxSaved = 0;
        for (int i = 1; i < N - 1; i++) {
            int original = checkpoints[i - 1].dist(checkpoints[i]) + checkpoints[i].dist(checkpoints[i + 1]);
            int skipped = checkpoints[i - 1].dist(checkpoints[i + 1]);
            int saved = original - skipped;
            maxSaved = Math.max(maxSaved, saved);
        }

        System.out.println(totalDistance - maxSaved);
    }
}
