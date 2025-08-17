import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine().trim());
        int[] C = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) C[i] = Integer.parseInt(st.nextToken());

        // 큐(0)인 곳의 B만 모아 "역순"으로 덱 구성
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] == 0) dq.addLast(B[i]);
        }

        StringBuilder sb = new StringBuilder();
        if (dq.isEmpty()) {
            // 큐가 하나도 없으면 결과는 입력 C 그대로
            for (int i = 0; i < M; i++) {
                sb.append(C[i]).append(' ');
            }
        } else {
            for (int i = 0; i < M; i++) {
                int out = dq.pollFirst(); // 현재 결과
                sb.append(out).append(' ');
                dq.addLast(C[i]);         // 새로 들어온 값은 맨 뒤로
            }
        }
        System.out.println(sb.toString().trim());
    }
}
