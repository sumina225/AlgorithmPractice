import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int server = 0;
        for(int i = 0; i < players.length; i++){
            while(!deque.isEmpty() && deque.peekFirst() == i){
                deque.pollFirst();
                server--;
            }
            int num = players[i] / m;
            if(server < num){
                int temp = server;
                for(int j = 0; j < num-temp; j++){
                    deque.offerLast(i+k);
                    server++;
                    answer++;
                }
            }
        }
        return answer;
    }
}