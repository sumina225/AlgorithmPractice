import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            a += n;
            sb.append(a).append("\n");
        }
        System.out.println(sb.toString());
    }
}