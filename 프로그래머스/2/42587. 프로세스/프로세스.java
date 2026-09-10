import java.util.*;

class Solution {
    static class Process{
        int priority;
        int location;
        
        public Process(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Process> deque = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            deque.addLast(new Process(priorities[i],i));
        }
        Arrays.sort(priorities);
        int num = priorities.length-1;
        while(!deque.isEmpty()){
            Process process = deque.pollFirst();
            if(process.priority == priorities[num]){
                if(process.location == location) {
                    answer = priorities.length - num;
                }
                num--;
            } else {
                deque.addLast(process);
            }
        }
        
        return answer;
    }
}