import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int answer = 0;
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(set.contains(s)) continue;
            set.add(s);
            count++;
            if(game.equals("Y") && count == 1){
                answer++;
                count = 0;
            }else if(game.equals("F") && count == 2){
                answer++;
                count = 0;
            }else if(game.equals("O") && count == 3){
                answer++;
                count = 0;
            }
        }
        System.out.println(answer);
    }
}
