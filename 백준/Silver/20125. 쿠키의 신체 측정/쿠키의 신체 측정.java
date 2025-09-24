import java.io.*;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j);
            }
        }
        Pos heart = new Pos(0,0);
        cute : for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == '*' && i-1 >= 0 && i+1 < n && j-1 >= 0 && j+1 < n && map[i-1][j] == '*' && map[i+1][j] == '*' && map[i][j-1] == '*' && map[i][j+1] == '*'){
                    heart = new Pos(i,j);
                    break cute;
                }
            }
        }
        int leftArm = 0;
        int rightArm = 0;
        int body = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        Pos pos = new Pos(heart.r,heart.c-1);
        while(map[pos.r][pos.c] == '*'){
            leftArm++;
            pos.c--;
            if(pos.c < 0) break;
        }
        pos = new Pos(heart.r,heart.c+1);
        while(map[pos.r][pos.c] == '*'){
            rightArm++;
            pos.c++;
            if(pos.c >= n) break;
        }
        pos = new Pos(heart.r+1,heart.c);
        Pos bodyEnd = new Pos(heart.r+1,heart.c);
        while(map[pos.r][pos.c] == '*'){
            body++;
            pos.r++;
            if(pos.r >= n) break;
            bodyEnd.r++;
        }
        bodyEnd.r--;
        pos = new Pos(bodyEnd.r+1,bodyEnd.c-1);
        while(map[pos.r][pos.c] == '*'){
            leftLeg++;
            pos.r++;
            if(pos.r >= n) break;
        }
        pos = new Pos(bodyEnd.r+1,bodyEnd.c+1);
        while(map[pos.r][pos.c] == '*'){
            rightLeg++;
            pos.r++;
            if(pos.r >= n) break;
        }
        sb.append(heart.r+1).append(" ").append(heart.c+1).append("\n");
        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(body).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb.toString());

    }
}
