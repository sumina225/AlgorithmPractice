import java.util.*;

class Solution {
    
    static class Pos{
        int r;
        int c;
        int count;
        
        public Pos(int r, int c, int count){
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        Deque<Pos> q = new ArrayDeque<>();
        boolean isPossible = false;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
    
        q.addFirst(new Pos(0,0,1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Pos pos = q.pollFirst();
            if(pos.r == maps.length-1 && pos.c == maps[0].length-1){
                isPossible = true;
                answer = pos.count;
                break;
            }
            for(int i = 0; i < 4; i++){
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < maps.length && nc < maps[0].length && !visited[nr][nc] && maps[nr][nc] == 1){
                    q.addLast(new Pos(nr,nc,pos.count+1));
                    visited[nr][nc] = true;
                }
            }
        }
        if(isPossible){
            return answer; 
        }
        return -1;
    }
}