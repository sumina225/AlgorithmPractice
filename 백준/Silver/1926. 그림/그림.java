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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int total = 0;
        int max = 0;
        boolean[][] visited = new boolean[n][m];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int count = 0;
                if(!visited[i][j] && nums[i][j] == 1){
                    total++;
                    Queue<Pos> queue = new LinkedList<>();
                    queue.add(new Pos(i,j));
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        Pos pos = queue.poll();
                        count++;
                        for(int k = 0; k < 4; k++){
                            int nr = pos.r + dr[k];
                            int nc = pos.c + dc[k];
                            if(nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && nums[nr][nc] == 1){
                                queue.add(new Pos(nr,nc));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    if(count > max) max = count;
                }
            }
        }
        System.out.println(total);
        System.out.println(max);
    }
}