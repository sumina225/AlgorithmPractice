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
        String s = br.readLine();
        char[] arr = s.toCharArray();
        int ans = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] <= arr[i-1]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}