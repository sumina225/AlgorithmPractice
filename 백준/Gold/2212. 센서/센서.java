import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pos = new int[n];
        for(int i = 0; i < n; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }
        int[] gaps = new int[n-1];
        Arrays.sort(pos);
        for(int i = 0; i < n-1; i++){
            gaps[i] = pos[i+1]-pos[i];
        }
        Arrays.sort(gaps);
        long total = 0;
        for(int g : gaps){
            total += g;
        }
        if(k >= n){
            System.out.println(0);
            return;
        }
        for(int i = 0; i < k-1; i++){
            total -= gaps[gaps.length-1-i];
        }
        System.out.println(total);
    }
}
