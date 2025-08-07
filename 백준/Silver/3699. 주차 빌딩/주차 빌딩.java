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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Pos[] parking = new Pos[h*l+1];
            int max = 0;
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < l; j++){
                    int num = Integer.parseInt(st.nextToken());
                    if(num != -1){
                        if(num > max){
                            max = num;
                        }
                        parking[num] = new Pos(i,j);
                    }
                }
            }
            int[] cur = new int[h];
            int time = 0;
            for(int i = 1; i <= max; i++){
                int dr = parking[i].r*2;
                //
                int dc = Math.min(Math.abs(cur[parking[i].r]-parking[i].c), l - Math.abs(cur[parking[i].r] - parking[i].c));
                time += dr*10 + dc*5;
                cur[parking[i].r] = parking[i].c;
            }
            sb.append(time).append("\n");
        }
        System.out.println(sb);
    }
}
