import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0){
                list.add(num);
            }
        }
        for(int i = list.size()-1; i >= 0; i--){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}