import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = 0;  // 반드시 long

        for (int i = 0; i < N; i++) {
            answer++;  // 총감독관 1명
            int remain = A[i] - B;

            if (remain > 0) {
                answer += (remain + C - 1) / C;  // 부감독관 필요한 수
            }
        }

        System.out.println(answer);
    }
}
