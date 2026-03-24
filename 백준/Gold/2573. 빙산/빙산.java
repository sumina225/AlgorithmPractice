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
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean isZero = false;
        int answer = 0;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(!isZero){
            int count = 0;
            boolean[][] visited = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visited[i][j] && nums[i][j] != 0){
                        count++;
                        Queue<Pos> queue = new LinkedList<>();
                        queue.add(new Pos(i,j));
                        visited[i][j] = true;
                        while(!queue.isEmpty()){
                            Pos pos = queue.poll();
                            for(int k = 0; k < 4; k++){
                                int nr = pos.r + dr[k];
                                int nc = pos.c + dc[k];
                                if(nr >= 0 && nc >= 0 && nr < n && nc < m && nums[nr][nc] != 0 && !visited[nr][nc]){
                                    queue.add(new Pos(nr,nc));
                                    visited[nr][nc] = true;
                                }
                            }
                        }
                    }
                }
            }
            if(count >= 2){
                break;
            }else if(count == 0){
                isZero = true;
            }
            answer++;
            int[][] copy = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(nums[i][j] > 0){
                        int min = 0;
                        for(int k = 0; k < 4; k++){
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if(nr >= 0 && nc >= 0 && nr < n && nc < m && nums[nr][nc] == 0){
                                min++;
                            }
                        }
                        copy[i][j] = Math.max(nums[i][j] - min, 0);
                    }else{
                        copy[i][j] = 0;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                nums[i] = copy[i].clone();
            }
        }
        System.out.println(isZero ? 0 : answer);
    }
}