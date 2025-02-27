import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 이동 거리
            long d = y - x;
            // d의 제곱근의 정수부분 n
            long n = (long) Math.sqrt(d);

            // d가 정확히 n²인 경우
            if (n * n == d) {
                sb.append(2 * n - 1).append("\n");
            }
            // d가 n²보다 크면서 n²+n 이하인 경우
            else if (d <= n * n + n) {
                sb.append(2 * n).append("\n");
            }
            // d가 n²+n보다 큰 경우
            else {
                sb.append(2 * n + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}