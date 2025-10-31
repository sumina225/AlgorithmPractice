import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] wire = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken()); // A 전봇대 번호
            wire[i][1] = Integer.parseInt(st.nextToken()); // B 전봇대 번호
        }

        // ✅ Comparator 사용 (A 전봇대 기준 오름차순 정렬)
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // ✅ LIS (B 전봇대 기준)
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 자기 자신 포함
            for (int j = 0; j < i; j++) {
                if (wire[j][1] < wire[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        // ✅ 최소 제거 개수 = 전체 개수 - LIS 길이
        System.out.println(n - max);
    }
}
