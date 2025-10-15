import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        boolean allRed = true;
        boolean allBlue = true;
        for (int i = 0; i < N; i++) {
            char c = balls.charAt(i);
            if (c != 'R') allRed = false;
            if (c != 'B') allBlue = false;
        }

        if (allRed || allBlue) {
            System.out.println(0);
            return;
        }

        int totalR = 0, totalB = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') totalR++;
            else totalB++;
        }

        int minMove = Integer.MAX_VALUE;

        int leftR = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') leftR++;
            else break;
        }
        minMove = Math.min(minMove, totalR - leftR);

        // 2️⃣ R을 오른쪽으로 모으기
        int rightR = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') rightR++;
            else break;
        }
        minMove = Math.min(minMove, totalR - rightR);

        // 3️⃣ B를 왼쪽으로 모으기
        int leftB = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'B') leftB++;
            else break;
        }
        minMove = Math.min(minMove, totalB - leftB);

        // 4️⃣ B를 오른쪽으로 모으기
        int rightB = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') rightB++;
            else break;
        }
        minMove = Math.min(minMove, totalB - rightB);

        System.out.println(minMove);
    }
}
