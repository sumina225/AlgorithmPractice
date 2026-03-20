import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;

            int distSq = dx * dx + dy * dy;           // 중심 거리 제곱
            int sum = (r1 + r2) * (r1 + r2);          // 반지름 합 제곱
            int diff = (r1 - r2) * (r1 - r2);         // 반지름 차 제곱

            // 1. 완전히 같은 원 → 무한대
            if (distSq == 0 && r1 == r2) {
                sb.append(-1).append("\n");
            }
            // 2. 만나지 않음
            else if (distSq > sum || distSq < diff) {
                sb.append(0).append("\n");
            }
            // 3. 한 점에서 만남 (접함)
            else if (distSq == sum || distSq == diff) {
                sb.append(1).append("\n");
            }
            // 4. 두 점에서 만남
            else {
                sb.append(2).append("\n");
            }
        }

        System.out.print(sb);
    }
}