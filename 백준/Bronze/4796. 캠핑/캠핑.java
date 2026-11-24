import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(true) {
            count++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(l == 0 && p == 0 && v == 0) {
                break;
            }
            sb.append("Case ").append(count).append(": ");
            int ans = (v/p)*l + Math.min(v%p, l);
            sb.append(ans).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}