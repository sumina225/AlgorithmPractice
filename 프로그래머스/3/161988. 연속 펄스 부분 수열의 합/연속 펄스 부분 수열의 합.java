import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long best1 = Long.MIN_VALUE, best2 = Long.MIN_VALUE;
        long cur1 = 0, cur2 = 0;
        for (int i = 0; i < sequence.length; i++) {
            long v1 = ((i & 1) == 0 ? 1L : -1L) * sequence[i]; // + - + - ...
            long v2 = -v1;                                     // - + - + ...
            cur1 = Math.max(v1, cur1 + v1);
            cur2 = Math.max(v2, cur2 + v2);
            best1 = Math.max(best1, cur1);
            best2 = Math.max(best2, cur2);
        }
        return Math.max(best1, best2);
    }
}
