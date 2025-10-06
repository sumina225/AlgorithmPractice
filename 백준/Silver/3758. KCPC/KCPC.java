import java.io.*;
import java.util.*;

public class Main {
    static class Team {
        int id;
        int totalScore;
        int submitCount;
        int lastSubmitTime;
        Map<Integer, Integer> problemScores; // 문제번호 -> 최고점수

        Team(int id) {
            this.id = id;
            this.totalScore = 0;
            this.submitCount = 0;
            this.lastSubmitTime = 0;
            this.problemScores = new HashMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 당신 팀의 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

            // 팀 정보 초기화
            Map<Integer, Team> teams = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                teams.put(i, new Team(i));
            }

            // 로그 처리
            for (int time = 0; time < m; time++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                Team team = teams.get(teamId);
                team.submitCount++;
                team.lastSubmitTime = time;

                // 해당 문제의 최고 점수 갱신
                int prevScore = team.problemScores.getOrDefault(problemNum, 0);
                if (score > prevScore) {
                    team.totalScore = team.totalScore - prevScore + score;
                    team.problemScores.put(problemNum, score);
                }
            }

            // 팀들을 리스트로 변환하고 정렬
            List<Team> teamList = new ArrayList<>(teams.values());
            teamList.sort((a, b) -> {
                // 1. 최종 점수가 높은 팀이 순위가 높음 (내림차순)
                if (a.totalScore != b.totalScore) {
                    return b.totalScore - a.totalScore;
                }

                // 2. 제출 횟수가 적은 팀이 순위가 높음 (오름차순)
                if (a.submitCount != b.submitCount) {
                    return a.submitCount - b.submitCount;
                }

                // 3. 마지막 제출 시간이 빠른 팀이 순위가 높음 (오름차순)
                return a.lastSubmitTime - b.lastSubmitTime;
            });

            // 당신 팀의 순위 찾기
            int rank = 1;
            for (Team team : teamList) {
                if (team.id == t) {
                    break;
                }
                rank++;
            }

            bw.write(rank + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}