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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n][m];
        List<Pos> ice = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
                if(nums[i][j] > 0){
                    ice.add(new Pos(i,j));
                }
            }
        }

        int answer = 0;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        while(true){

            // ✅ 1. 빙산 덩어리 체크 (BFS 1번만)
            if(ice.isEmpty()){
                System.out.println(0);
                return;
            }

            boolean[][] visited = new boolean[n][m];
            Queue<Pos> queue = new LinkedList<>();

            Pos start = ice.get(0);
            queue.add(start);
            visited[start.r][start.c] = true;

            int connected = 1;

            while(!queue.isEmpty()){
                Pos cur = queue.poll();
                for(int k = 0; k < 4; k++){
                    int nr = cur.r + dr[k];
                    int nc = cur.c + dc[k];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < m
                        && nums[nr][nc] > 0 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.add(new Pos(nr,nc));
                        connected++;
                    }
                }
            }

            // 👉 덩어리 2개 이상
            if(connected != ice.size()){
                System.out.println(answer);
                return;
            }

            // ✅ 2. 녹이기 (ice만 순회)
            int[][] melt = new int[n][m];

            for(Pos p : ice){
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < m
                        && nums[nr][nc] == 0){
                        cnt++;
                    }
                }
                melt[p.r][p.c] = cnt;
            }

            // ✅ 3. 실제 반영 + ice 갱신
            List<Pos> newIce = new ArrayList<>();

            for(Pos p : ice){
                int r = p.r;
                int c = p.c;

                nums[r][c] = Math.max(nums[r][c] - melt[r][c], 0);

                if(nums[r][c] > 0){
                    newIce.add(new Pos(r,c));
                }
            }

            ice = newIce;
            answer++;
        }
    }
}