import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int dasom = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        int count = 0;
        while(!pq.isEmpty() && pq.peek() >= dasom){
            int num = pq.poll();
            num--;
            dasom++;
            count++;
            pq.add(num);
        }
        System.out.println(count);
    }
}