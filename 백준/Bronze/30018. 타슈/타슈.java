import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int num = as[i] - Integer.parseInt(st.nextToken());
            if(num > 0){
                answer += num;
            }
        }
        System.out.println(answer);
    }
}