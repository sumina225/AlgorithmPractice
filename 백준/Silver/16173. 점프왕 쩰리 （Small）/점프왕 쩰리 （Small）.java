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
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            int num = nums[now.r][now.c];
            if((now.r+num == n-1 && now.c == n-1) || (now.r == n-1 && now.c+num == n-1)){
                System.out.println("HaruHaru");
                return;
            }
            if(now.r + num < n && !visited[now.r+num][now.c]){
                visited[now.r+num][now.c] = true;
                queue.add(new Pos(now.r+num,now.c));
            }
            if(now.c + num < n && !visited[now.r][now.c+num]){
                visited[now.r][now.c+num] = true;
                queue.add(new Pos(now.r,now.c+num));
            }
        }
        System.out.println("Hing");
    }
}