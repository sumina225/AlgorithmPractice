import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int easy;
        int hard;
        Pair(int e, int h) {
            easy = e;
            hard = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(pairs, (a, b) -> a.hard - b.hard);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(k == 0) break;
            if(pairs[i].hard <= l) {
                ans += 140;
                k--;
            } else {
                if(pairs[i].easy <= l) {
                    ans += 100;
                    k--;
                }
            }
        }
        System.out.println(ans);
    }
}