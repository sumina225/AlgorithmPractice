import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);

        String[] parts = s.split("\\},\\{");

        Arrays.sort(parts, (a, b) ->
            a.split(",").length - b.split(",").length
        );

        Set<Integer> set = new HashSet<>();
        int[] answer = new int[parts.length];
        int index = 0;

        for (String part : parts) {
            for (String num : part.split(",")) {
                int value = Integer.parseInt(num);

                if (set.add(value)) {
                    answer[index++] = value;
                }
            }
        }

        return answer;
    }
}