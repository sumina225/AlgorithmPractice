import java.util.*;

class Solution {
    
    static class Pos{
        int r;
        int c;
        int dir;
        int score;
        
        public Pos(int r, int c, int dir, int score){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.score = score;
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int rLen = board.length;
        int cLen = board[0].length;
        int[][][] dp = new int[rLen][cLen][4];
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                for(int k = 0; k < 4; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
                
            }
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0,0,-1,0));
        while(!deque.isEmpty()){
            Pos pos = deque.pollFirst();
            for(int i = 0; i < 4; i++){
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];
                int nScore = pos.score + 100;
                if(pos.dir != i){
                    if(pos.score == 0){
                        nScore += 0;
                    }else{
                        nScore += 500;
                    }
                    
                }
                if(nr >= 0 && nc >= 0 && nr < rLen && nc < cLen && nScore <= dp[nr][nc][i] && board[nr][nc] != 1){
                    deque.add(new Pos(nr,nc,i,nScore));
                    dp[nr][nc][i] = nScore;
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer,dp[rLen-1][cLen-1][i]);
        }
        return answer;
    }
}