import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pos{
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] foods = new boolean[n][m];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            foods[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }
        int max = 0;
        boolean[][] visited = new boolean[n][m];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(foods[i][j] && !visited[i][j]){
                    int count = 1;
                    Deque<Pos> deque = new ArrayDeque<>();
                    deque.addLast(new Pos(i,j));
                    visited[i][j] = true;
                    while(!deque.isEmpty()){
                        Pos pos = deque.pollFirst();
                        for(int d = 0; d < 4; d++){
                            int nr = pos.r + dr[d];
                            int nc = pos.c + dc[d];
                            if(nr >= 0 && nc >= 0 && nr < n && nc < m && foods[nr][nc] && !visited[nr][nc]){
                                count++;
                                visited[nr][nc] = true;
                                deque.addLast(new Pos(nr,nc));
                            }
                        }
                    }
                    if(count > max) max = count;
                }
            }
        }
        System.out.println(max);
    }
}