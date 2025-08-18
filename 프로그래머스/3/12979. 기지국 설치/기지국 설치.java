class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int j = 1;
        for(int i = 0; i < stations.length; i++) {
            while(j < stations[i] - w) {
                j += 2*w + 1;
                answer++;
            }
            if(j > n)
                break;
            j = stations[i] + w + 1;
        }
        if(j <= n) {
            while(j <= n) {
                j += 2*w + 1;
                answer++;
            }
        }
        return answer;
    }
}