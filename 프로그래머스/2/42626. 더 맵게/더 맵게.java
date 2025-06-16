import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(pq.peek() < K){
            int temp1 = pq.poll();
            int temp2 = pq.poll();
            result = temp1 + (temp2*2);
            pq.add(result);
            answer++;
            if(pq.size() < 2 && pq.peek() < K){
                answer = -1;
                break;
            };
        }
        
        return answer;
    }
}