import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == 1) continue;
            if(now % 2 == 0){
                int a = now/2;
                int b = now/2;
                if(a != 1){
                    queue.add(a);
                }
                if(b != 1){
                    queue.add(b);
                }
                answer += a*b;
            }else{
                int a = now / 2;
                int b = now / 2 + 1;
                if(a != 1){
                    queue.add(a);
                }
                if(b != 1){
                    queue.add(b);
                }
                answer += a*b;
            }
        }
        System.out.println(answer);
    }
}
