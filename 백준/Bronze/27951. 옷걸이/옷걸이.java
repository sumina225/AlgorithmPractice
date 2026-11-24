import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]]++;
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        u = Math.max(u-count[1], 0);
        d = Math.max(d-count[2], 0);
        if(u + d > count[3]){
            System.out.println("NO");
            return;
        } else {
            System.out.println("YES");
        }
        char[] ans = new char[n];
        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                ans[i] = 'U';
            } else if(arr[i] == 2){
                ans[i] = 'D';
            } else {
                if(u > 0){
                    ans[i] = 'U';
                    u--;
                } else if(d > 0){
                    ans[i] = 'D';
                    d--;
                }
            }
        }
        System.out.println(new String(ans));
    }
}