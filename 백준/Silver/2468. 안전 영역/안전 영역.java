import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] nums = new int[n][n];
        int max = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
                if(nums[i][j] > max){
                    max = nums[i][j];
                }
            }
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int answer = 0;
        for(int i = 0; i < max; i++){
            int result = 0;
            boolean[][] visited = new boolean[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(!visited[j][k] && nums[j][k] > i){
                        result++;
                        visited[j][k] = true;
                        Queue<Pos> queue = new LinkedList<>();
                        queue.add(new Pos(j,k));
                        while(!queue.isEmpty()){
                            Pos pos = queue.poll();
                            for(int l = 0; l < 4; l++){
                                int nr = pos.r + dr[l];
                                int nc = pos.c + dc[l];
                                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && nums[nr][nc] > i){
                                    visited[nr][nc] = true;
                                    queue.add(new Pos(nr,nc));
                                }
                            }
                        }
                    }
                }
            }
            if(result > answer){
                answer = result;
            }
        }
        System.out.println(answer);
    }
}