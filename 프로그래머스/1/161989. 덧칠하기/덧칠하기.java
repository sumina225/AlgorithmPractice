import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int last = -1;
        for(int i : section){
            if(i > last){
                answer++;
                last = i + m -1;
            }
        }
        
        return answer;
    }
}