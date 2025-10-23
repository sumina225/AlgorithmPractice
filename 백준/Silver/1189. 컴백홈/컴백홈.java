import java.io.*;
import java.util.*;

public class Main {

    static int answer;
    static int k;
    static boolean[][] visited;
    static int[] dr;
    static int[] dc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = 0;
        visited = new boolean[r][c];
        char[][] map = new char[r][c];
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
            }
        }
        dr = new int[]{-1,1,0,0};
        dc = new int[]{0,0,-1,1};
        visited[r-1][0] = true;
        func(map,r-1,0,1);
        System.out.println(answer);
    }

    public static void func(char[][] map,int r, int c, int count){
        if(count > k) return;
        if(r == 0 && c == map[0].length-1){
            if(count == k){
                answer++;
            }
            return;
        }
        for(int i = 0; i < 4; i++){
            int nr = r+dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length && !visited[nr][nc] && map[nr][nc] == '.'){
                visited[nr][nc] = true;
                func(map,nr,nc,count+1);
                visited[nr][nc] = false;
            }
        }
    }
}
