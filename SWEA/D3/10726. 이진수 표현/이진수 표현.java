import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int bit = (1 << n) -1;
            sb.append("#").append(t).append(" ");
            if((bit & m) == bit) sb.append("ON");
            else sb.append("OFF");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}