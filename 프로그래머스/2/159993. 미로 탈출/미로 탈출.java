import java.util.*;

class Solution {
    
    static class Pos{
        int r;
        int c;
        int count;
        int isPossible;
        
        public Pos(int r, int c, int count, int isPossible){
            this.r = r;
            this.c = c;
            this.count = count;
            this.isPossible = isPossible;
        }
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        int[][][] visited = new int[maps.length][maps[0].length()][2];
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[i].length; j++){
                for(int k = 0; k < visited[i][j].length; k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        PriorityQueue<Pos> queue = new PriorityQueue<>(new Comparator<Pos>(){
            @Override
            public int compare(Pos a, Pos b){
                return a.count - b.count;
            }
        });
        cute : for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    queue.add(new Pos(i,j,0,0));
                    break cute;
                }
            }
        }
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            if((maps[pos.r].charAt(pos.c) == 'E') && pos.isPossible == 1){
                answer = pos.count;
                break;
            }
            for(int i = 0; i < 4; i++){
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < maps.length && nc < maps[nr].length() && visited[nr][nc][pos.isPossible] > pos.count + 1 && maps[nr].charAt(nc) != 'X'){
                    if(maps[nr].charAt(nc) == 'L'){
                        queue.add(new Pos(nr,nc,pos.count+1,1));
                        visited[nr][nc][1] = pos.count+1;
                    }else{
                        queue.add(new Pos(nr,nc,pos.count+1,pos.isPossible));    
                        visited[nr][nc][pos.isPossible] = pos.count+1;
                    }

                }
            }
        }
        
        return answer;
    }
}