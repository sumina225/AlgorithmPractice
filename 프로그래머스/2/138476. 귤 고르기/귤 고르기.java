import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());

        int answer = 0;
        int sum = 0;

        for (int count : counts) {
            sum += count;
            answer++;

            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}