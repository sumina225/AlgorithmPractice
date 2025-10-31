import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            sb.append("w(")
                    .append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(") = ")
                    .append(w(a, b, c))
                    .append("\n");
        }

        System.out.print(sb);
    }

    static int w(int a, int b, int c) {
        // 기저 조건
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        // 20을 넘으면 dp[20][20][20]로 고정
        if (a > 20 || b > 20 || c > 20)
            return dp[20][20][20] = w(20, 20, 20);

        // 이미 계산된 값이면 재사용
        if (dp[a][b][c] != 0) return dp[a][b][c];

        // 조건 분기
        if (a < b && b < c)
            dp[a][b][c] = w(a, b, c - 1)
                    + w(a, b - 1, c - 1)
                    - w(a, b - 1, c);
        else
            dp[a][b][c] = w(a - 1, b, c)
                    + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1)
                    - w(a - 1, b - 1, c - 1);

        return dp[a][b][c];
    }
}
