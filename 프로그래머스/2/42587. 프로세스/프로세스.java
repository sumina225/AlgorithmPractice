import java.util.*;

public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            boolean hasHigher = false;
            for (int[] p : q) {
                if (p[0] > cur[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                q.offer(cur);
            } else {
                count++;  
                if (cur[1] == location) {
                    return count;
                }
            }
        }
        return count;
    }
}
