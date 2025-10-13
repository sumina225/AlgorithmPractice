import java.io.*;
import java.util.*;

public class Main {
    static class Road {
        int start;
        int end;
        int length;
        Road(int s, int e, int l) {
            start = s;
            end = e;
            length = l;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Road> roads = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(end > d) continue;
            if(end-start <= length) continue;

            roads.add(new Road(start,end,length));
        }
        Collections.sort(roads, new Comparator<Road>(){
            @Override
            public int compare(Road a, Road b){
                return a.start-b.start;
            }
        });
        int[] dp = new int[d+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int idx = 0;
        for(int i = 0; i <= d; i++){
            if(i > 0){
                dp[i] = Math.min(dp[i], dp[i-1]+1);
            }
            while(idx < roads.size() && roads.get(idx).start == i){
                Road r = roads.get(idx);
                dp[r.end] = Math.min(dp[r.end], dp[r.start] + r.length);
                idx++;
            }
        }
        System.out.println(dp[d]);

    }
}
