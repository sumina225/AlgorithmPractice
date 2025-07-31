import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int round = 0; round < enemy.length; round++) {
            pq.add(enemy[round]);
            n -= enemy[round];

            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    return round;
                }
            }
        }
        return enemy.length;
    }
}