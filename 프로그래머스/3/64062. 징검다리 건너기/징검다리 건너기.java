class Solution {
    public int solution(int[] stones, int k) {
        int lo = 1, hi = 0;
        for (int s : stones) hi = Math.max(hi, s);
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int consecutive = 0;
            boolean ok = true;
            for (int s : stones) {
                if (s < mid) {
                    if (++consecutive >= k) { ok = false; break; }
                } else {
                    consecutive = 0;
                }
            }

            if (ok) { ans = mid; lo = mid + 1; }
            else { hi = mid - 1; }
        }
        return ans;
    }
}
