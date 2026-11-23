import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a % 2 == 1){
                count++;
                min = Math.min(min, a);
            }
            answer += a;
        }
        if(count % 2 == 1){
            answer -= min;
        }
        System.out.println(answer);
    }
}