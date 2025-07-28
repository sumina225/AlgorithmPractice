class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long[] longTimes = new long[times.length];
        for(int i = 0; i < times.length; i++){
            longTimes[i] = times[i];
        }
        long low = 1;
        long maxTimePerPerson = 0;
        for(long time : longTimes){
            if(time > maxTimePerPerson){
                maxTimePerPerson = time;
            }
        }
        long high = maxTimePerPerson * n;
        answer = high;
        while(low <= high){
            long mid = (low + high) / 2;
            long peopleCount = 0;
            for(long time : longTimes){
                peopleCount += mid / time;
                if(peopleCount >= n){
                    break;
                }
            }
            if(peopleCount >= n){
                answer = mid;
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
}