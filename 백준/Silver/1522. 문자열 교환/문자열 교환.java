import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();
        int cntA = 0;

        // 1. a 개수 세기
        for (char c : s.toCharArray()) {
            if (c == 'a') cntA++;
        }

        // 전부 a거나 전부 b인 경우
        if (cntA == 0 || cntA == n) {
            System.out.println(0);
            return;
        }

        // 2. 문자열 2배로
        String doubled = s + s;

        // 3. 초기 윈도우 설정 (0 ~ cntA-1)
        int left = 0, right = 0;
        int countB = 0;
        int minSwap = Integer.MAX_VALUE;

        // 초기 윈도우 채우기
        while (right < cntA) {
            if (doubled.charAt(right) == 'b') countB++;
            right++;
        }
        minSwap = countB;

        // 4. 슬라이딩 윈도우 이동
        while (right < doubled.length()) {
            // 왼쪽 문자 빠짐
            if (doubled.charAt(left) == 'b') countB--;
            // 오른쪽 문자 들어옴
            if (doubled.charAt(right) == 'b') countB++;

            minSwap = Math.min(minSwap, countB);

            left++;
            right++;
        }

        System.out.println(minSwap);
    }
}
