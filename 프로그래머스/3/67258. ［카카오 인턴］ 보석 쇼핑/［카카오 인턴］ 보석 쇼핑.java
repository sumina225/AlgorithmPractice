import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> kinds = new HashSet<>();
        for (String g : gems) {
            kinds.add(g);
        }
        int kind = kinds.size();
        Map<String, Integer> win = new HashMap<>();
        int n = gems.length;
        int l = 0;
        int r = 0;
        int bestLen = Integer.MAX_VALUE;
        int ansL = 0;
        int ansR = 0;

        while (true) {
            if (win.size() == kind) {
                if (r - l < bestLen) {
                    bestLen = r - l;
                    ansL = l;
                    ansR = r - 1; 
                }
                String g = gems[l];
                int c = win.get(g) - 1;
                if (c == 0) win.remove(g);
                else win.put(g, c);
                l++;
            } else {
                if (r == n) break;
                win.merge(gems[r], 1, Integer::sum);
                r++;
            }
        }

        return new int[]{ansL + 1, ansR + 1};
    }
}
