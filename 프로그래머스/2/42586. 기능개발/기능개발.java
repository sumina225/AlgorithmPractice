import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int day = 0;
        int index = 0;
        
        while(index < progresses.length) {
            int count = 0;
            day = (int) Math.ceil((100.0 - progresses[index]) / speeds[index]);
            while(index < progresses.length && 
                  Math.ceil((100.0 - progresses[index]) / speeds[index]) <= day) {
                count++;
                index++;
            }
            
            list.add(count);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
