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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int tc = 1; tc <= t; tc++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] sheeps = new char[h][w];
            for(int i = 0; i < h; i++){
                String s = br.readLine();
                for(int j = 0; j < w; j++){
                    sheeps[i][j] = s.charAt(j);
                }
            }
            int count = 0;
            boolean[][] visited = new boolean[h][w];
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(sheeps[i][j] == '#' && !visited[i][j]){
                        count++;
                        visited[i][j] = true;
                        Deque<Pos> deque = new ArrayDeque<>();
                        deque.addLast(new Pos(i,j));
                        while(!deque.isEmpty()){
                            Pos pos = deque.pollFirst();
                            for(int k = 0; k < 4; k++){
                                int nr = pos.r + dr[k];
                                int nc = pos.c + dc[k];
                                if(nr >= 0 && nc >= 0 && nr < h && nc < w && sheeps[nr][nc] == '#' && !visited[nr][nc]){
                                    deque.add(new Pos(nr,nc));
                                    visited[nr][nc] = true;
                                }
                            }
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}