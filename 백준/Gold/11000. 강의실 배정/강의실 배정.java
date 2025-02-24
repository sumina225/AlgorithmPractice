import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Time> list;

    static class Time{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.start - o2.start;
            }
        });
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).end);

        for(int i = 1; i < N; i++){
            if(list.get(i).start >= pq.peek()){
                pq.poll();
            }
            pq.add(list.get(i).end);
        }
        System.out.println(pq.size());

    }
}