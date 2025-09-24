import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        if(n <= 0) {
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int num = 1;
        int same = 0;
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(newScore > temp){
                if(same > 0) num += same;
                break;
            }else if(newScore == temp){
                same++;
            }else{
                num++;
            }
            if(i == n-1){
                num += same;
            }
        }
        if(num <= p){
            System.out.println(num-same);
        }else{
            System.out.println(-1);
        }

    }
}
