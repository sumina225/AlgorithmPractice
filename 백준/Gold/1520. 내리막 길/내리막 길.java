import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 아직 계산하지 않은 상태
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int r, int c) {
        // 도착 지점이면 경로 1개 완성
        if (r == m - 1 && c == n - 1) return 1;

        // 이미 계산된 적 있으면 바로 반환 (메모이제이션)
        if (dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0; // 초기화
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n && map[nr][nc] < map[r][c]) {
                dp[r][c] += dfs(nr, nc);
            }
        }

        return dp[r][c];
    }
}
