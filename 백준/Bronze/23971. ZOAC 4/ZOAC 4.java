import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int height = h / (n+1);
        height += h % (n+1) == 0 ? 0 : 1;
        int weight = w / (m+1);
        weight += w % (m+1) == 0 ? 0 : 1;
        System.out.println(height*weight);
    }
}
