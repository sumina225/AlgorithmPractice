import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 굴다리의 길이
        int M = sc.nextInt(); // 가로등 개수
        int[] lights = new int[M];

        for (int i = 0; i < M; i++) {
            lights[i] = sc.nextInt();
        }

        int left = 0;         // 최소 높이
        int right = N;        // 최대 높이
        int answer = N;

        while (left <= right) {
            int mid = (left + right) / 2; // 현재 가로등 높이

            if (canLightAll(N, lights, mid)) {
                answer = mid;
                right = mid - 1; // 더 낮은 높이도 가능한지 확인
            } else {
                left = mid + 1;  // 더 높은 높이 필요
            }
        }

        System.out.println(answer);
    }

    // 해당 높이로 모든 구간을 커버할 수 있는지 확인
    public static boolean canLightAll(int N, int[] lights, int height) {
        int lastLit = 0;

        for (int i = 0; i < lights.length; i++) {
            int start = lights[i] - height;
            int end = lights[i] + height;

            // 구간이 이어지지 않는 경우
            if (start > lastLit) {
                return false;
            }

            lastLit = Math.max(lastLit, end);
        }

        return lastLit >= N;
    }
}
