import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= order.length; i++){
            q.add(i);
        }
        int idx = 0;
        Stack<Integer> s = new Stack<>();
        while(idx < order.length){
            if(!q.isEmpty() && order[idx] == q.peek()){
                idx++;
                q.poll();
                answer++;
            }else if(!s.isEmpty() && order[idx] == s.peek()){
                idx++;
                s.pop();
                answer++;
            }else{
                if(q.isEmpty()){
                    break;
                }else{
                    s.add(q.poll());
                }
            }
        }
        return answer;
    }
}