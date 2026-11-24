import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] costs = new int[n];
            int[] mins = new int[n];
            Arrays.fill(mins, Integer.MAX_VALUE);
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                for(int j = 0; j < c; j++){
                    map.put(Integer.parseInt(st.nextToken()), i);
                }
                costs[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= m; i++){
                int num = Integer.parseInt(st.nextToken());
                if(map.get(i) == null) {
                    continue;
                }
                mins[map.get(i)] = Math.min(mins[map.get(i)], num);
            }
            int ans = 0;
            for(int i = 0; i < n; i++){
                ans += costs[i]*mins[i];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}