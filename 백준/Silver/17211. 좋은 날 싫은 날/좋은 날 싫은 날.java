import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cur = Integer.parseInt(st.nextToken());   // 0 = good, 1 = bad

        st = new StringTokenizer(br.readLine());
        double p00 = Double.parseDouble(st.nextToken()); // good -> good
        double p01 = Double.parseDouble(st.nextToken()); // good -> bad
        double p10 = Double.parseDouble(st.nextToken()); // bad -> good
        double p11 = Double.parseDouble(st.nextToken()); // bad -> bad

        // 현재 확률 벡터 준비
        double good = (cur == 0 ? 1.0 : 0.0);
        double bad  = (cur == 1 ? 1.0 : 0.0);

        // N일 동안 반복
        for (int i = 0; i < n; i++) {
            double nextGood = good * p00 + bad * p10;
            double nextBad  = good * p01 + bad * p11;

            good = nextGood;
            bad = nextBad;
        }

        // 반올림하여 출력
        int outGood = (int)(good * 1000 + 0.5);
        int outBad  = (int)(bad * 1000 + 0.5);

        System.out.println(outGood + " " + outBad);
    }
}
