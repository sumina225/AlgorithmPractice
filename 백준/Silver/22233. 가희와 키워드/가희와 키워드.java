import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        for(int i = 0; i < m; i++){
            String[] s = br.readLine().split(",");
            for(int j = 0; j < s.length; j++){
                if(set.contains(s[j])){
                    set.remove(s[j]);
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
