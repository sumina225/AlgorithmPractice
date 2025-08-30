import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        boolean isPossible = false;
        while(!isPossible){
            Arrays.sort(bill);
            isPossible = true;
            for(int i = 0; i < 2; i++){
                if(wallet[i] < bill[i]){
                    isPossible = false;
                }
            }
            bill[1] /= 2;
            answer++;
        }
        return answer-1;
    }
}