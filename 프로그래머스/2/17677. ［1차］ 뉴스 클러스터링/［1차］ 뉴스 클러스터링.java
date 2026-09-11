import java.util.*;

class Solution {

    public int solution(String str1, String str2) {

        Map<String, Integer> map1 = makeMap(str1.toUpperCase());
        Map<String, Integer> map2 = makeMap(str2.toUpperCase());

        int intersection = 0;
        int union = 0;

        // 교집합 계산
        for (String key : map1.keySet()) {

            if (map2.containsKey(key)) {
                intersection += Math.min(
                    map1.get(key),
                    map2.get(key)
                );
            }
        }

        // 합집합 계산
        Set<String> keys = new HashSet<>();

        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {

            int cnt1 = map1.getOrDefault(key, 0);
            int cnt2 = map2.getOrDefault(key, 0);

            union += Math.max(cnt1, cnt2);
        }

        // 둘 다 공집합인 경우
        if (union == 0) {
            return 65536;
        }

        return (int) ((double) intersection / union * 65536);
    }


    private Map<String, Integer> makeMap(String str) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {

            char a = str.charAt(i);
            char b = str.charAt(i + 1);

            // 둘 다 영문자인 경우만 사용
            if (a >= 'A' && a <= 'Z'
                    && b >= 'A' && b <= 'Z') {

                String word = str.substring(i, i + 2);

                map.put(
                    word,
                    map.getOrDefault(word, 0) + 1
                );
            }
        }

        return map;
    }
}