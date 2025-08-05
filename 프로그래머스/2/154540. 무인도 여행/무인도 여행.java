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
    
    public int[] solution(String[] maps) {
        List<Integer> answerTemp = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] map = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) == 'X'){
                    map[i][j] = 0;
                }else{
                    map[i][j] = maps[i].charAt(j)-'0';
                }
            }
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    Queue<Pos> queue = new LinkedList<>();
                    queue.add(new Pos(i,j));
                    visited[i][j] = true;
                    int total = 0;
                    while(!queue.isEmpty()){
                        Pos pos = queue.poll();
                        total += map[pos.r][pos.c];
                        for(int k = 0; k < 4; k++){
                            int nr = pos.r + dr[k];
                            int nc = pos.c + dc[k];
                            if(nr >= 0 && nc >= 0 && nr < map.length && nc < map[i].length && !visited[nr][nc] && map[nr][nc] != 0){
                                queue.add(new Pos(nr,nc));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    answerTemp.add(total);
                }
            }
        }
        if(answerTemp.isEmpty()){
            return new int[]{-1};
        }
        int[] answer = new int[answerTemp.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerTemp.get(i);
        }
    
        Arrays.sort(answer);
        return answer;
    }
}