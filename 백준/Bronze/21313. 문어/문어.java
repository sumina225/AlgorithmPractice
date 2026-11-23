import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n-1; i++) {
            sb.append(i % 2 + 1).append(" ");
        }
        if(n % 2 == 0) {
            sb.append(2);
        }else {
            sb.append(3);
        }
        System.out.println(sb.toString());
        br.close();
    }
}