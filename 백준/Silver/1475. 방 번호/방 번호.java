import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] count = new int[10];

        // 각 숫자 개수 세기
        for (char c : N.toCharArray()) {
            count[c - '0']++;
        }

        // 6과 9는 공유
        int sixNine = (count[6] + count[9] + 1) / 2;

        int answer = sixNine;

        // 나머지 숫자 중 최대값 찾기
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            answer = Math.max(answer, count[i]);
        }

        System.out.println(answer);
    }
}
