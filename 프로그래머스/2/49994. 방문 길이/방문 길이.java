import java.util.*;

class Solution {
    static class Pos{
        int x;
        int y;
    }
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        Pos pos = new Pos();
        pos.x = 5;
        pos.y = 5;
        for(int i = 0; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            if(c == 'U' && pos.y < 10){
                visited[pos.x][pos.y][0] = true;
                pos.y++;
                visited[pos.x][pos.y][1] = true;

            }else if(c == 'D' && pos.y > 0){
                visited[pos.x][pos.y][1] = true;
                pos.y--;
                visited[pos.x][pos.y][0] = true;
            }else if(c == 'R' && pos.x < 10){
                visited[pos.x][pos.y][2] = true;
                pos.x++;
                visited[pos.x][pos.y][3] = true;
            }else if(c == 'L' && pos.x > 0){
                visited[pos.x][pos.y][3] = true;
                pos.x--;
                visited[pos.x][pos.y][2] = true;
            }
        }
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                for(int k = 0; k < 4; k++){
                    if(visited[i][j][k]){
                        answer++;
                    }
                }
            }
        }
        return answer/2;
    }
}