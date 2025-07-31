import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                answer++;
                Deque<Integer> q = new ArrayDeque<>();
                q.addLast(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int now = q.pollFirst();
                    for(int j = 0; j < computers[now].length; j++){
                        if(!visited[j] && now != j && computers[now][j] == 1){
                            q.addLast(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
}