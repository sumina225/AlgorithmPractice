import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;

        while (true) {
            int e = year % 15;
            int s = year % 28;
            int m = year % 19;

            if (e == 0) e = 15;
            if (s == 0) s = 28;
            if (m == 0) m = 19;

            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            year++;
        }
    }
}
