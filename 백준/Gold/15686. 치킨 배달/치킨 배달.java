import java.io.*;
import java.util.*;

// 좌표를 표현하기 위한 Pos 클래스 정의
class Pos {
    int x, y;

    // 생성자
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m; // 도시의 크기와 고를 치킨집의 최대 개수
    static List<Pos> houses = new ArrayList<>(); // 집의 위치를 저장할 리스트
    static List<Pos> chickens = new ArrayList<>(); // 치킨집의 위치를 저장할 리스트
    static boolean[] visited; // 선택된 치킨집을 표시하기 위한 배열
    static int answer = Integer.MAX_VALUE; // 도시의 치킨 거리의 최솟값

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 도시 정보 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    // 집일 경우
                    houses.add(new Pos(i, j));
                } else if (value == 2) {
                    // 치킨집일 경우
                    chickens.add(new Pos(i, j));
                }
            }
        }

        // 조합을 사용해 M개의 치킨집을 선택
        visited = new boolean[chickens.size()];
        combination(0, 0);
        
        // 결과 출력
        System.out.println(answer);
    }

    // 조합을 이용해 M개의 치킨집 선택
    static void combination(int start, int count) {
        if (count == m) {
            // 선택된 M개의 치킨집으로 도시의 치킨 거리 계산
            int totalDistance = 0;

            // 모든 집에 대해 각 치킨집과의 최소 거리를 구하고 더함
            for (Pos house : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (visited[i]) {
                        Pos chicken = chickens.get(i);
                        int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                        minDist = Math.min(minDist, distance);
                    }
                }
                totalDistance += minDist;
            }

            // 도시의 치킨 거리의 최솟값 갱신
            answer = Math.min(answer, totalDistance);
            return;
        }

        // 조합을 이용해 M개의 치킨집 선택
        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
