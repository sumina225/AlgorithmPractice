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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        int count = 0;
        int ans = 0;
        for(int i = 1; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(max > num){
                count++;
            } else {
                max = num;
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        System.out.println(Math.max(ans, count));
    }
}