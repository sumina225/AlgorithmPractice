import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char char1 = str1.charAt(i);
            char char2 = str1.charAt(i + 1);
            if (char1 >= 'a' && char1 <= 'z' && char2 >= 'a' && char2 <= 'z') {
                list1.add(str1.substring(i, i + 2));
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char char1 = str2.charAt(i);
            char char2 = str2.charAt(i + 1);
            if (char1 >= 'a' && char1 <= 'z' && char2 >= 'a' && char2 <= 'z') {
                list2.add(str2.substring(i, i + 2));
            }
        }

        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        List<String> temp_list2 = new ArrayList<>(list2);

        for (String s : list1) {
            if (temp_list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        union.addAll(temp_list2);

        double jaccardSimilarity;
        if (union.isEmpty()) {
            jaccardSimilarity = 1.0;
        } else {
            jaccardSimilarity = (double) intersection.size() / union.size();
        }

        int answer = (int) (jaccardSimilarity * 65536);
        return answer;
    }
}