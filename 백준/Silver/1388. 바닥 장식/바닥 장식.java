import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] room = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                room[i][j] = s.charAt(j);
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    answer++;
                    if(room[i][j] == '-'){
                        int num = j+1;
                        while(num < m && !visited[i][num] && room[i][num] == '-'){
                            visited[i][num] = true;
                            num++;
                        }
                    }else{
                        int num = i+1;
                        while(num < n && !visited[num][j] && room[num][j] == '|'){
                            visited[num][j] = true;
                            num++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
