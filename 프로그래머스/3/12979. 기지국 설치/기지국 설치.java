import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        Arrays.sort(stations);
        int cover = 2*w + 1;
        int answer = 0;
        int start = 1;                    // 아직 커버 안 된 구간의 시작

        for (int s : stations) {
            int left = Math.max(1, s - w); // 이 기지국의 커버 시작
            if (start < left) {            // 이전 커버 끝~이번 커버 시작 사이의 빈 구간
                int gap = left - start;
                answer += (gap + cover - 1) / cover; // ceil(gap / cover)
            }
            start = Math.min(n + 1, s + w + 1); // 다음 미커버 시작으로 이동
        }

        if (start <= n) {                  // 마지막 꼬리 구간 처리
            int gap = n - start + 1;
            answer += (gap + cover - 1) / cover;
        }
        return answer;
    }
}
