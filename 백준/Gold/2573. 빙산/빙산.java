import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pos{
        int r, c;
        Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        int year = 0;

        while(true){

            int count = 0;
            boolean[][] visited = new boolean[n][m];

            // ✅ 덩어리 개수 체크
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] > 0 && !visited[i][j]){
                        count++;

                        Queue<Pos> q = new ArrayDeque<>();
                        q.add(new Pos(i,j));
                        visited[i][j] = true;

                        while(!q.isEmpty()){
                            Pos cur = q.poll();

                            for(int k = 0; k < 4; k++){
                                int nr = cur.r + dr[k];
                                int nc = cur.c + dc[k];

                                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                                    if(map[nr][nc] > 0 && !visited[nr][nc]){
                                        visited[nr][nc] = true;
                                        q.add(new Pos(nr,nc));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 👉 2덩어리 이상
            if(count >= 2){
                System.out.println(year);
                return;
            }

            // 👉 다 녹음
            if(count == 0){
                System.out.println(0);
                return;
            }

            // ✅ 녹이기
            int[][] copy = new int[n][m];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] > 0){
                        int cnt = 0;

                        for(int k = 0; k < 4; k++){
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                                if(map[nr][nc] == 0) cnt++;
                            }
                        }

                        copy[i][j] = Math.max(map[i][j] - cnt, 0);
                    }
                }
            }

            map = copy;
            year++;
        }
    }
}