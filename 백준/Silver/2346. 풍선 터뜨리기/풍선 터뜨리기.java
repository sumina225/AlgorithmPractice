import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer[]> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            deque.addLast(new Integer[]{Integer.parseInt(st.nextToken()),i+1});
        }
        while(!deque.isEmpty()){
            Integer[] num = deque.pollFirst();
            sb.append(num[1]).append(" ");
            if(deque.isEmpty()) break;
            if(num[0] > 0){
                for(int i = 0; i < num[0]-1; i++){
                    Integer[] temp = deque.pollFirst();
                    deque.addLast(temp);
                }
            }else{
                for(int i = 0; i < -num[0]; i++){
                    Integer[] temp = deque.pollLast();
                    deque.addFirst(temp);
                }
            }
        }
        System.out.println(sb.toString());
    }
}