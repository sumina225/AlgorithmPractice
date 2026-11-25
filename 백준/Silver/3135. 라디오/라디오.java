import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            min = Math.min(min, Math.abs(num - b));
        }
        if(min < Math.abs(a - b)){
            System.out.println(min+1);
        } else {
            System.out.println(Math.abs(a - b));
        }
    }
}