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
        long n = Long.parseLong(br.readLine());
        int ans = 0;
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                if(n == 1){
                    n -= 1;
                }else {
                    n -= n / 2;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}