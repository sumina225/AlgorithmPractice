import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        long low = 1;
        long high = num[n-1] - num[0];
        long answer = 0;
        while(low <= high){
            long mid = (low + high) / 2;
            int count = 1;
            long lastInstalled = num[0];
            for(int i = 1; i < n; i++){
                if(num[i] - lastInstalled >= mid){
                    count++;
                    lastInstalled = num[i];
                }
            }
            if(count >= m){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
