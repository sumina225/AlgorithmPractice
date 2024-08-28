import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] nums; // 각 구역의 인접 구역 리스트
    public static int[] people; // 각 구역의 인구 수
    public static int sum; // 전체 인구의 합
    public static int min = Integer.MAX_VALUE; // 인구 차이의 최솟값
    public static boolean[] visited; // 방문한 구역을 체크하기 위한 배열
    public static int n; // 구역의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 구역의 개수 입력
        people = new int[n + 1]; // 인구 수 배열 초기화
        visited = new boolean[n + 1]; // 방문 체크 배열 초기화
        sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken()); // 각 구역의 인구 수 입력
            sum += people[i]; // 전체 인구 수 계산
        }

        nums = new ArrayList[n + 1]; // 각 구역의 인접 구역을 저장할 리스트 배열 초기화
        for (int i = 1; i <= n; i++) {
            nums[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int last = Integer.parseInt(st.nextToken()); // 현재 구역의 인접 구역 개수
            for (int j = 0; j < last; j++) {
                nums[i].add(Integer.parseInt(st.nextToken())); // 인접 구역 추가
            }
        }

        // 모든 가능한 부분집합을 생성하여 검사
        for (int i = 1; i < (1 << n); i++) {
            List<Integer> group1 = new ArrayList<>();
            List<Integer> group2 = new ArrayList<>();
            
            // 부분집합을 두 그룹으로 나누기
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    group1.add(j + 1);
                } else {
                    group2.add(j + 1);
                }
            }

            // 두 그룹 중 하나라도 비어있으면 넘어감
            if (group1.isEmpty() || group2.isEmpty()) continue;

            // 두 그룹이 모두 연결되어 있는지 확인
            if (isConnected(group1) && isConnected(group2)) {
                // 그룹1의 인구 총합 계산
                int sumGroup1 = 0;
                for (int node : group1) {
                    sumGroup1 += people[node];
                }

                // 그룹2의 인구 총합 계산
                int sumGroup2 = 0;
                for (int node : group2) {
                    sumGroup2 += people[node];
                }

                // 인구 차이의 최솟값 갱신
                min = Math.min(min, Math.abs(sumGroup1 - sumGroup2));
            }
        }

        // 만약 min이 초기값인 경우 -1로 설정
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min); // 결과 출력
    }

    // 주어진 그룹이 연결되어 있는지 확인하는 메서드
    public static boolean isConnected(List<Integer> group) {
        boolean[] visitedInGroup = new boolean[n + 1]; // 그룹 내 방문 체크 배열
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group.get(0)); // 시작 노드 추가
        visitedInGroup[group.get(0)] = true;
        int countVisited = 1; // 방문한 노드 수

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : nums[node]) {
                if (group.contains(neighbor) && !visitedInGroup[neighbor]) {
                    visitedInGroup[neighbor] = true;
                    queue.add(neighbor);
                    countVisited++;
                }
            }
        }
        // 그룹 내 모든 노드가 연결되었는지 확인
        return countVisited == group.size();
    }
}
