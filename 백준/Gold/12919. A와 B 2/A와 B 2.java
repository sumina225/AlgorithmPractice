import java.io.*;
import java.util.*;

public class Main {
    static String s, t;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        func(new StringBuilder(t));
        System.out.println(isPossible ? 1 : 0);
    }

    static void func(StringBuilder cur) {
        if (cur.length() == s.length()) {
            if (cur.toString().equals(s)) isPossible = true;
            return;
        }

        if (cur.charAt(cur.length() - 1) == 'A') {
            cur.deleteCharAt(cur.length() - 1);
            func(cur);
            cur.append('A'); // 원상복구
        }

        if (cur.charAt(0) == 'B') {
            cur.reverse();
            cur.deleteCharAt(cur.length() - 1);
            func(cur);
            cur.append('B').reverse(); // 원상복구
        }
    }
}
