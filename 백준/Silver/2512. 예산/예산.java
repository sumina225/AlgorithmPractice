import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] local = new int[n];
        for(int i = 0; i < n; i++){
            local[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(local);
        int high = local[n-1];
        int max = Integer.parseInt(br.readLine());
        int low = 0;
        int answer = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(local[i] > mid){
                    sum += mid;
                }else{
                    sum += local[i];
                }
            }
            if(sum <= max){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
