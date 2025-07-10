class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int low = 1; 
        int high = 100000;
        int answer = high;

        while (low <= high) {
            int mid = (high + low) / 2;
            
            long totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= mid) {
                    totalTime += times[i];
                } else {
                    if (i == 0) {
                        totalTime += (long)times[i] * (diffs[i] - mid + 1);
                    } else {
                        totalTime += (long)(times[i] + times[i - 1]) * (diffs[i] - mid) + times[i];
                    }
                }
            }
            if (totalTime <= limit) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return answer;
    }
}