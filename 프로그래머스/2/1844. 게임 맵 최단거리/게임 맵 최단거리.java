import java.util.*;

class Solution {
    
    static class Pos{
        int r;
        int c;
        
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = -1;
        Deque<Pos> deque = new ArrayDeque<>();
        int[][] visited = new int[maps.length][maps[0].length];
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[i].length; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        deque.addLast(new Pos(0,0));
        visited[0][0] = 1;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!deque.isEmpty()){
            Pos pos = deque.pollFirst();
            for(int i = 0; i < 4; i++){
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < maps.length && nc < maps[0].length && maps[nr][nc] == 1 && visited[pos.r][pos.c] + 1 < visited[nr][nc]){
                    visited[nr][nc] = visited[pos.r][pos.c] + 1;
                    deque.addLast(new Pos(nr,nc));
                }
            }
        }
        if(visited[maps.length-1][maps[0].length-1] == Integer.MAX_VALUE){
            visited[maps.length-1][maps[0].length-1] = -1;  
        }
        return visited[maps.length-1][maps[0].length-1];
    }
}