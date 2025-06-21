class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        for(int i = 1; i <= sum; i++){
            int j = 0;
            if(sum % i == 0){
                j = sum / i;
            }else{
                continue;
            }
            if(brown == 2*i + 2*j - 4){
                answer = new int[]{j,i};
                break;
            }
            
        }
        return answer;
    }
}