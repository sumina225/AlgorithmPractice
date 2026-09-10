import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] days = new int[speeds.length];
        for(int i = 0; i < speeds.length; i++){
            int num = 1;
            while(progresses[i] + speeds[i]*num < 100){
                num++;
            }
            days[i] = num;
        }
        int start = 0;
        int complete = 1;
        int count = 1;
        while(complete < days.length){
            if(days[complete] <= days[start]){
                count++;
                complete++;
            }else {
                list.add(count);
                count = 1;
                start = complete;
                complete++;
            }
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}