import java.util.*;

class Solution {
    
    static class Pos{
        int now;
        int count;
        
        public Pos(int now, int count){
            this.now = now;
            this.count = count;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] roads = new int[N][N];
        for(int i = 0; i < road.length; i++){
            if(roads[road[i][0]-1][road[i][1]-1] != 0){
                roads[road[i][0]-1][road[i][1]-1] = Math.min(roads[road[i][0]-1][road[i][1]-1],road[i][2]);
                roads[road[i][1]-1][road[i][0]-1] = Math.min(roads[road[i][1]-1][road[i][0]-1],road[i][2]);
            }else{
                roads[road[i][0]-1][road[i][1]-1] = road[i][2];
                roads[road[i][1]-1][road[i][0]-1] = road[i][2];
            }
        }
        PriorityQueue<Pos> queue = new PriorityQueue<>(new Comparator<Pos>(){
            @Override
            public int compare(Pos a, Pos b){
                return a.count - b.count;
            }
        });
        queue.add(new Pos(0,0));
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[N];
        for(int i = 1; i < N; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            if(pos.count <= K){
                set.add(pos.now);
            }
            for(int i = 0; i < N; i++){
                if(pos.now != i && roads[pos.now][i] != 0 && pos.count + roads[pos.now][i] < dp[i] && pos.count + roads[pos.now][i] <= K){
                    queue.add(new Pos(i,pos.count + roads[pos.now][i]));
                    dp[i] = pos.count + roads[pos.now][i];
                }
            }
        }
        answer = set.size();
        return answer;
    }
}