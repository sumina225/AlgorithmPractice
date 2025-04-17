import java.util.*;

public class Solution {
    public int solution(int[] priorities, int location) {
        // 큐에는 [우선순위, 원래 인덱스] 형태의 배열을 저장
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});  // 처음 대기 큐 설정
        }

        int count = 0;  // 실행된 프로세스 순서 카운터
        while (!q.isEmpty()) {
            int[] cur = q.poll();  // 큐에서 하나 꺼내기
            boolean hasHigher = false;

            // 큐에 남은 프로세스 중 더 높은 우선순위가 있는지 확인
            for (int[] p : q) {
                if (p[0] > cur[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // 더 높은 우선순위가 있으면 뒤로 재배치
                q.offer(cur);
            } else {
                // 가장 우선순위가 높으므로 실행
                count++;  
                // 실행된 프로세스가 우리가 찾는 위치라면 순서 반환
                if (cur[1] == location) {
                    return count;
                }
            }
        }
        return count;  // 안전장치: 모든 프로세스가 실행된 후 반환
    }
}
