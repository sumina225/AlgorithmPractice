import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        while(!pq.isEmpty() && pq.peek() <= l) {
            int num = pq.poll();
            if(num <= l){
                l++;
            }
        }
        System.out.println(l);
    }
}