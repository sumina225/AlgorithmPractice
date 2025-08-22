import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // nCr (0<=n,m<30) 파스칼 삼각형 미리 계산
        long[][] comb = new long[30][30];
        for (int n = 0; n < 30; n++) {
            comb[n][0] = comb[n][n] = 1;
            for (int r = 1; r < n; r++) {
                comb[n][r] = comb[n - 1][r - 1] + comb[n - 1][r];
            }
        }

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 서쪽
            int M = Integer.parseInt(st.nextToken()); // 동쪽
            sb.append(comb[M][N]).append('\n');       // M곳 중 N곳 선택 = C(M, N)
        }

        System.out.print(sb);
    }
}
