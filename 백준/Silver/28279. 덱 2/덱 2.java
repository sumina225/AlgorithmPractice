import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("1")){
                deque.addFirst(Integer.parseInt(s[1]));
            }else if(s[0].equals("2")){
                deque.addLast(Integer.parseInt(s[1]));
            }else if(s[0].equals("3")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.pollFirst()).append("\n");
                }
            }else if(s[0].equals("4")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.pollLast()).append("\n");
                }
            }else if(s[0].equals("5")){
                sb.append(deque.size()).append("\n");
            }else if(s[0].equals("6")){
                if(deque.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(s[0].equals("7")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekFirst()).append("\n");
                }
            }else{
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}