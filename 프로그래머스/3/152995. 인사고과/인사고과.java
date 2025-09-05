import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wanhoFirst = scores[0][0];
        int wanhoSecond = scores[0][1];
        int wanhoSum = wanhoFirst + wanhoSecond;
        
        // 첫 번째 점수 내림차순, 두 번째 점수 오름차순 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // 첫 번째 점수 내림차순
            }
            return a[1] - b[1]; // 두 번째 점수 오름차순
        });
        
        int maxSecond = 0;
        boolean[] valid = new boolean[scores.length];
        Arrays.fill(valid, true);
        
        // 인센티브를 받을 수 없는 사원 찾기 (O(n))
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < maxSecond) {
                // 첫 번째 점수는 이미 이전 원소들보다 작거나 같고,
                // 두 번째 점수도 이전의 최대값보다 작으므로 인센티브 못받음
                valid[i] = false;
                
                // 완호가 인센티브를 못받는 경우
                if (scores[i][0] == wanhoFirst && scores[i][1] == wanhoSecond) {
                    return -1;
                }
            } else {
                maxSecond = Math.max(maxSecond, scores[i][1]);
            }
        }
        
        // 완호보다 점수 합이 높은 사원 수 계산
        for (int i = 0; i < scores.length; i++) {
            if (!valid[i]) continue;
            
            int sum = scores[i][0] + scores[i][1];
            if (sum > wanhoSum) {
                answer++;
            }
        }
        
        return answer;
    }
}