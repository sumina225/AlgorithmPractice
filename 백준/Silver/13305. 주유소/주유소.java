import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long[] road = new long[n-1];
        long[] price = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++){
            road[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            price[i] = Long.parseLong(st.nextToken());
        }
        long min = Long.MAX_VALUE;
        long total = 0;
        for(int i = 0; i < n-1; i++){
            if(min > price[i]){
                min = price[i];
            }
            total += min*road[i];
        }
        System.out.println(total);
    }
}