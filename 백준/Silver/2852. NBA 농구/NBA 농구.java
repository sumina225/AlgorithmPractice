import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;

        int lead1 = 0;
        int lead2 = 0;

        int prevTime = 0; // 이전 시간(초 단위)

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);

            // 시간 파싱
            String[] time = input[1].split(":");
            int minute = Integer.parseInt(time[0]);
            int second = Integer.parseInt(time[1]);
            int currentTime = minute * 60 + second;

            // 현재 득점 전까지 리드 시간 계산
            if (score1 > score2) {
                lead1 += currentTime - prevTime;
            } else if (score2 > score1) {
                lead2 += currentTime - prevTime;
            }

            // 점수 반영
            if (team == 1) {
                score1++;
            } else {
                score2++;
            }

            prevTime = currentTime;
        }

        // 48분(2880초)까지 처리
        int endTime = 48 * 60;

        if (score1 > score2) {
            lead1 += endTime - prevTime;
        } else if (score2 > score1) {
            lead2 += endTime - prevTime;
        }

        // 출력 형식 맞추기
        int m1 = lead1 / 60;
        int s1 = lead1 % 60;

        int m2 = lead2 / 60;
        int s2 = lead2 % 60;

        System.out.printf("%02d:%02d\n", m1, s1);
        System.out.printf("%02d:%02d\n", m2, s2);
    }
}