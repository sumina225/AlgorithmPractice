import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int answer = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(s.equals("ENTER")){
                set.clear();
                continue;
            }else if(set.contains(s)){
                continue;
            }else{
                set.add(s);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
