import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                sb.append(num++).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}