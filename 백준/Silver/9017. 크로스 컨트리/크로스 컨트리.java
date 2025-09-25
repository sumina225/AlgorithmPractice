import java.io.*;
import java.util.*;

public class Main {

    static class Team {
        int index;        // 팀 번호
        int count;        // 총 참가자 수
        int score;        // 상위 4명 점수 합
        int fifthScore;   // 5번째 주자의 점수
        List<Integer> scores; // 점수 기록

        public Team(int index) {
            this.index = index;
            this.count = 0;
            this.score = 0;
            this.fifthScore = 0;
            this.scores = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] players = new int[N]; // 등수 순서대로 팀 번호 저장
            Map<Integer, Team> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                players[i] = teamNum;
                map.putIfAbsent(teamNum, new Team(teamNum));
                map.get(teamNum).count++;
            }

            // 점수 배정 (무효 팀 건너뜀)
            int point = 1;
            for (int i = 0; i < N; i++) {
                int teamNum = players[i];
                Team t = map.get(teamNum);

                if (t.count < 6) continue; // 무효 팀은 점수 배정 X

                t.scores.add(point);

                if (t.scores.size() <= 4) {
                    t.score += point;
                } else if (t.scores.size() == 5) {
                    t.fifthScore = point;
                }

                point++;
            }

            // 유효 팀만 후보
            List<Team> candidates = new ArrayList<>();
            for (Team t : map.values()) {
                if (t.count == 6) {
                    candidates.add(t);
                }
            }

            // 정렬
            candidates.sort((a, b) -> {
                if (a.score != b.score) return a.score - b.score;
                return a.fifthScore - b.fifthScore;
            });

            sb.append(candidates.get(0).index).append("\n");
        }

        System.out.println(sb);
    }
}
