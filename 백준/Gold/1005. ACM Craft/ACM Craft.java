import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] time = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) time[i] = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            int[] indeg = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                // x -> y (x가 끝나야 y 시작 가능)
                adj[x].add(y);
                indeg[y]++;
            }

            int W = Integer.parseInt(br.readLine().trim());

            // dp[i] : i 건물을 완성하는 데 필요한 최소 시간(= 최장 누적 경로)
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) dp[i] = time[i];

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indeg[i] == 0) q.add(i);
            }

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj[u]) {
                    // u를 통해 v로 올 때의 누적 시간
                    if (dp[v] < dp[u] + time[v]) {
                        dp[v] = dp[u] + time[v];
                    }
                    indeg[v]--;
                    if (indeg[v] == 0) q.add(v);
                }
            }

            sb.append(dp[W]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
