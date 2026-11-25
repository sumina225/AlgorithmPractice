import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int maxIdx = Math.max(b, Math.max(c, d));
        st = new StringTokenizer(br.readLine());
        Integer[] bs = new Integer[maxIdx];
        Integer[] cs = new Integer[maxIdx];
        Integer[] ds = new Integer[maxIdx];
        Arrays.fill(bs, 0);
        Arrays.fill(cs, 0);
        Arrays.fill(ds, 0);
        int max = 0;
        for(int i = 0; i < b; i++) {
            bs[i] = Integer.parseInt(st.nextToken());
            max += bs[i];
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++) {
            cs[i] = Integer.parseInt(st.nextToken());
            max += cs[i];
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < d; i++) {
            ds[i] = Integer.parseInt(st.nextToken());
            max += ds[i];
        }
        Arrays.sort(bs, Collections.reverseOrder());
        Arrays.sort(cs, Collections.reverseOrder());
        Arrays.sort(ds, Collections.reverseOrder());
        int ans = 0;
        for(int i = 0; i < maxIdx; i++) {
            if(bs[i] == 0 || cs[i] == 0 || ds[i] == 0){
                ans += bs[i] + cs[i] + ds[i];
            } else {
                ans += (bs[i] + cs[i] + ds[i])*9/10;
            }
        }
        System.out.println(max);
        System.out.println(ans);
    }
}