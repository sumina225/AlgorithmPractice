import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            String s = br.readLine();
            sb.append(check(s) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean check(String s) {
        // 길이가 1이면 더 이상 접을 수 없음
        if (s.length() == 1) return true;

        int mid = s.length() / 2;

        // 중심을 기준으로 좌우 확인
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                return false; // 같으면 안 됨 (IN-IN or OUT-OUT)
            }
        }

        // 좌우 부분 문자열도 같은 규칙으로 확인
        return check(s.substring(0, mid)) && check(s.substring(mid + 1));
    }

}
