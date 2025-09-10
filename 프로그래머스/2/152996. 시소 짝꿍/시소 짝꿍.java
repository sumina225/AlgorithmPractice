import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();

        // 1) 빈도수 카운트
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        // 2) 같은 무게 쌍 (nC2)
        for (long cnt : map.values()) {
            if (cnt > 1) answer += (cnt * (cnt - 1)) / 2;
        }

        // 3) 비율 매칭 (중복 카운팅 방지: other > w 인 경우만 더함)
        int[] num = {2, 2, 3, 3, 4, 4};
        int[] den = {3, 4, 2, 4, 2, 3};

        // 키를 정렬하면 other > w 체크가 명확해짐
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int w : keys) {
            long cnt = map.get(w);
            for (int i = 0; i < 6; i++) {
                long numerator = num[i];
                long denominator = den[i];

                long prod = (long) w * numerator;
                if (prod % denominator != 0) continue; // 정수가 아니면 패스
                int other = (int) (prod / denominator);

                if (other <= w) continue; // 중복 카운팅 방지 (또는 자기자신 중복 제외)
                if (map.containsKey(other)) {
                    answer += cnt * map.get(other);
                }
            }
        }

        return answer;
    }
}
