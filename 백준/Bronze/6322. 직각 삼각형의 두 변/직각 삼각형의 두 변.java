import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            count++;
            if(a==0 && b==0 && c==0) break;
            sb.append("Triangle #").append(count).append("\n");
            if((a >= c || b >= c) && c != -1){
                sb.append("Impossible.").append("\n\n");

                continue;
            }
            if(a == -1) {
                double num = Math.pow(c,2) - Math.pow(b,2);
                sb.append("a = ").append(String.format("%.3f", Math.sqrt(num))).append("\n\n");
            } else if(b == -1) {
                double num = Math.pow(c,2) - Math.pow(a,2);
                sb.append("b = ").append(String.format("%.3f", Math.sqrt(num))).append("\n\n");
            } else {
                double num = Math.pow(a,2) + Math.pow(b,2);
                sb.append("c = ").append(String.format("%.3f", Math.sqrt(num))).append("\n\n");
            }
        }
        System.out.println(sb.toString());
    }
}
