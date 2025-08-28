import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1]; // win[a][b] = a가 b를 이김

        for (int[] r : results) win[r[0]][r[1]] = true;

        // Floyd–Warshall: a가 b를 이기고 b가 c를 이기면 a가 c를 이김
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (!win[i][k]) continue;
                for (int j = 1; j <= n; j++) {
                    if (win[k][j]) win[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int known = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (win[i][j] || win[j][i]) known++; // i와 j의 우열이 확정
            }
            if (known == n - 1) answer++; // 모든 상대와 비교 결과가 확정 → 순위 확정
        }
        return answer;
    }
}
