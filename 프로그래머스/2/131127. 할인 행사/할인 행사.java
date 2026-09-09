import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 첫 10일 세팅
        for (int i = 0; i < 10; i++) {
            window.put(
                discount[i],
                window.getOrDefault(discount[i], 0) + 1
            );
        }

        // 10일씩 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            boolean possible = true;

            for (String key : wantMap.keySet()) {
                int wantCount = wantMap.get(key);
                int discountCount = window.getOrDefault(key, 0);

                if (wantCount != discountCount) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                answer++;
            }

            // 다음 윈도우로 이동
            if (i + 10 < discount.length) {
                String remove = discount[i];
                String add = discount[i + 10];

                window.put(remove, window.get(remove) - 1);
                window.put(add, window.getOrDefault(add, 0) + 1);
            }
        }

        return answer;
    }
}