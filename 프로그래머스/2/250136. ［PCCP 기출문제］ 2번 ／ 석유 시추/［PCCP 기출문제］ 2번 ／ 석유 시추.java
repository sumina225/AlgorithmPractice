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
    
    
    public int solution(int[][] land) {
        int answer = 0;
        int rLen = land.length;
        int cLen = land[0].length;
        int[][] temp = new int[rLen][cLen];
        int[] count = new int[rLen*cLen];
        int index = 1;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(temp[i][j] != 0 || land[i][j] != 1){
                    continue;
                }
                ArrayDeque<Pos> queue = new ArrayDeque<>();
                queue.add(new Pos(i,j));
                temp[i][j] = index;
                int total = 1;
                while(!queue.isEmpty()){
                    Pos pos = queue.poll();
                    for(int k = 0; k < 4; k++){
                        int nr = pos.r + dr[k];
                        int nc = pos.c + dc[k];
                        if(nr >= 0 && nc >= 0 && nr < rLen && nc < cLen && temp[nr][nc] == 0 && land[nr][nc] == 1){
                            queue.add(new Pos(nr,nc));
                            total++;
                            temp[nr][nc] = index;
                        }
                    }
                }
                count[index] = total;
                index++;
                
            }
        }
        for(int i = 0; i < cLen; i++){
            int sum = 0;
            boolean[] visited = new boolean[index];
            for(int j = 0; j < rLen; j++){
                if(temp[j][i] == 0 || visited[temp[j][i]]){
                    continue;
                }else{
                    sum += count[temp[j][i]];
                    visited[temp[j][i]] = true;
                    
                }
            }
            if(sum > answer){
                answer = sum;
            }
        }
        
        
        return answer;
    }
}