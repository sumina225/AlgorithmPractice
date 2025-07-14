import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            sb.append(s);
        }
        System.out.println(sb);
    }
}