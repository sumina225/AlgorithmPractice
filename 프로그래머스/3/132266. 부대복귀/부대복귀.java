import java.util.*;

class Solution {
    
    static class Count{
        int now;
        int count;
        
        public Count(int now, int count){
            this.now = now;
            this.count = count;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = -1;
        }
        List<Integer>[] map = new ArrayList[n];
        for(int i = 0; i < map.length; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0; i < roads.length; i++){
            map[roads[i][0]-1].add(roads[i][1]-1);
            map[roads[i][1]-1].add(roads[i][0]-1);
        }
        
        Deque<Count> deque = new ArrayDeque<>();
        deque.addLast(new Count(destination-1,0));
        number[destination-1] = 0;
        while(!deque.isEmpty()){
            Count temp = deque.pollFirst();
            for(int j = 0; j < map[temp.now].size(); j++){
                if(number[map[temp.now].get(j)] == -1){
                    deque.addLast(new Count(map[temp.now].get(j), temp.count+1));
                    number[map[temp.now].get(j)] = temp.count+1;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = number[sources[i]-1];
        }
        
        
        return answer;
    }
}