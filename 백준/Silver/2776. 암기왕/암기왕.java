import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] memo1 = new int[n];
            for(int i = 0; i < n; i++){
                memo1[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] memo2 = new int[m];
            for(int i = 0; i < m; i++){
                memo2[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(memo1);
            for(int i = 0; i < m; i++){
                int low = 0;
                int high = n-1;
                boolean isTrue = false;
                while(low <= high){
                    int mid = (low + high) / 2;
                    if(memo2[i] < memo1[mid]){
                        high = mid-1;
                    }else if(memo2[i] > memo1[mid]){
                        low = mid+1;
                    }else{
                        isTrue = true;
                        break;
                    }
                }
                if(isTrue){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
