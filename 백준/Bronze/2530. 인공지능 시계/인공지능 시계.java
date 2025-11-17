import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int D = Integer.parseInt(br.readLine());
        
        int current = A * 3600 + B * 60 + C;
        int end = (current + D) % 86400;
        
        int hour = end / 3600;
        int minute = (end % 3600) / 60;
        int second = end % 60;
        
        System.out.println(hour + " " + minute + " " + second);
    }
}
