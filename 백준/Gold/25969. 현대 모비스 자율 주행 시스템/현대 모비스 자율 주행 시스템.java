import java.io.*;
import java.util.*;

public class Main {

    static class Pos{
        int r;
        int c;
        int count;
        boolean isPossible;
        int pattern;

        public Pos(int r, int c, int count, int pattern, boolean isPossible){
            this.r = r;
            this.c = c;
            this.count = count;
            this.pattern = pattern;
            this.isPossible = isPossible;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] patternMap = new int[5][5];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                patternMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = Integer.MAX_VALUE;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0,0,0,K,false));
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int[][][][] dp = new int[2][K+1][N][M];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j <= K; j++){
                for(int k = 0; k < N; k++){
                    for(int l = 0; l < M; l++){
                        dp[i][j][k][l] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        dp[0][K][0][0] = 0;
        while(!q.isEmpty()){
            Pos pos = q.poll();

            int isCan = pos.isPossible ? 1 : 0;
            if(pos.count > dp[isCan][pos.pattern][pos.r][pos.c]) continue;

            if(result <= pos.count) continue;
            if(pos.r == N-1 && pos.c == M-1 && pos.isPossible){
                result = pos.count;
            }

            if(pos.pattern > 0){
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j < 5; j++){
                        int nr = pos.r + (i-2);
                        int nc = pos.c + (j-2);
                        if(nr >= 0 && nc >= 0 && nr < N && nc < M && patternMap[i][j] == 1 && map[nr][nc] != 1){
                            int newCount = pos.count + 1;
                            if(newCount > result) continue;

                            if(map[nr][nc] == 2) {
                                if(newCount < dp[1][pos.pattern-1][nr][nc]) {
                                    dp[1][pos.pattern-1][nr][nc] = newCount;
                                    q.add(new Pos(nr, nc, newCount, pos.pattern - 1, true));
                                }
                            } else {
                                if(newCount < dp[isCan][pos.pattern-1][nr][nc]) {
                                    dp[isCan][pos.pattern-1][nr][nc] = newCount;
                                    q.add(new Pos(nr, nc, newCount, pos.pattern - 1, pos.isPossible));
                                }
                            }
                        }
                    }
                }
            }

            for(int i = 0; i < 4; i++){
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != 1){
                    int newCount = pos.count + 1;
                    if(newCount > result) continue;

                    if(map[nr][nc] == 2) {
                        if(newCount < dp[1][pos.pattern][nr][nc]) {
                            dp[1][pos.pattern][nr][nc] = newCount;
                            q.add(new Pos(nr, nc, newCount, pos.pattern, true));
                        }
                    } else {
                        if(newCount < dp[isCan][pos.pattern][nr][nc]) {
                            dp[isCan][pos.pattern][nr][nc] = newCount;
                            q.add(new Pos(nr, nc, newCount, pos.pattern, pos.isPossible));
                        }
                    }
                }
            }
        }

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}