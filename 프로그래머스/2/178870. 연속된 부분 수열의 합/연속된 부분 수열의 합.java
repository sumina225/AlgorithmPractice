class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        if(sum == k) return new int[]{0,0};
        int sLen = sequence.length;
        while(right < sLen && left < sLen){
            if(sum > k){
                left++;
                if(left >= sLen) break;
                sum -= sequence[left-1];
            }else if(sum == k){
                if(answer[0] == 0 && answer[1] == 0){
                    answer[0] = left;
                    answer[1] = right;
                }else if(right - left < answer[1] - answer[0]){
                    answer[0] = left;
                    answer[1] = right;
                }
                left++;
                right++;
                if(left >= sLen || right >= sLen) break;
                sum = sum - sequence[left-1] + sequence[right];
            }else{
                right++;
                if(right >= sLen) break;
                sum += sequence[right];
            }
        }
        return answer;
    }
}