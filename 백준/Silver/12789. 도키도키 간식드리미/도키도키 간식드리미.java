import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            deque.addLast(Integer.parseInt(st.nextToken()));
        }
        int now = 1;
        Stack<Integer> rest = new Stack<>();
        while(now <= n){
            if(deque.isEmpty() && rest.peek() != now){
                break;
            }
            if(!rest.isEmpty() && rest.peek() == now){
                rest.pop();
                now++;
                continue;
            }
            int temp = deque.pollFirst();
            if(temp != now){
                rest.add(temp);
            }else{
                now++;
            }
        }
        if(now > n){
            System.out.println("Nice");
        }else{
            System.out.println("Sad");
        }
    }
}