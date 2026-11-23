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
        int status = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == status){
                answer++;
                status = (status + 1) % 3;
            }
        }
        System.out.println(answer);
    }
}