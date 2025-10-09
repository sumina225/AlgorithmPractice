import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int totalZero = 0, totalOne = 0;
        for (char c : S.toCharArray()) {
            if (c == '0') totalZero++;
            else totalOne++;
        }

        int needZero = totalZero / 2;  // 남길 0
        int needOne = totalOne / 2;    // 남길 1

        int remainZero = totalZero;
        int remainOne = totalOne;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '0') {
                // 0을 넣는 게 좋지만, 남길 수 있는 0이 아직 있다면
                // 무조건 넣지 말고 뒤의 균형도 고려
                if (needZero > 0) {
                    result.append('0');
                    needZero--;
                }
                remainZero--;
            } else { // c == '1'
                // 남은 1 중 절반을 제거해야 하므로, 지금 1을 넣을지 판단
                if (remainOne > needOne) {
                    // 아직 버릴 여유가 있으면 버림
                    remainOne--;
                } else {
                    // 더는 버리면 안 되므로 넣음
                    result.append('1');
                    needOne--;
                    remainOne--;
                }
            }
        }

        System.out.println(result.toString());
    }
}
