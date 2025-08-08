import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        // 상태: t + 3*g + 9*f + 27*p  (각각 0~2)
        long[] freq = new long[81];
        freq[0] = 1; // 빈 prefix

        int t = 0, g = 0, f = 0, p = 0; // 각 문자 누적 mod 3
        long ans = 0;

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'T': t = (t + 1) % 3; break;
                case 'G': g = (g + 1) % 3; break;
                case 'F': f = (f + 1) % 3; break;
                case 'P': p = (p + 1) % 3; break;
            }
            int state = t + 3*g + 9*f + 27*p;
            ans += freq[state];
            freq[state]++;
        }

        System.out.println(ans);
    }
}
