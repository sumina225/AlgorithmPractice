import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < q; tc++){
            st = new StringTokenizer(br.readLine());
            int ta = Integer.parseInt(st.nextToken());
            int tb = Integer.parseInt(st.nextToken());
            int va = Integer.parseInt(st.nextToken());
            int vb = Integer.parseInt(st.nextToken());
            int time = 0;
            int a = 0;
            int dohunA = 0;
            int b = 0;
            while(va > 0 || vb > 0){
                time++;
                if(va > 0) a++;

                if(vb > 0){
                    b++;
                }else{
                    dohunA++;
                }

                if(a == ta){
                    va--;
                    a = 0;
                }
                if(dohunA == ta){
                    va--;
                    dohunA = 0;
                }
                if(b == tb){
                    vb--;
                    b = 0;
                }
            }
            sb.append(time).append("\n");
        }
        System.out.println(sb.toString());
    }
}
