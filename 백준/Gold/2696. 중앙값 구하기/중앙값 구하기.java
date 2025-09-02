import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++){
            int m = Integer.parseInt(br.readLine());
            sb.append(m/2 + 1).append("\n");

            // maxHeap: 작은 값들 (중앙값 이하)
            // minHeap: 큰 값들 (중앙값 초과)
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            int cnt = 0; // 출력한 중앙값 개수

            for(int i = 1; i <= m; i++){
                // 10개씩 한 줄에 입력받기
                if(i > 10 && (i - 1) % 10 == 0){
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());

                // 값 추가 로직
                if(maxHeap.isEmpty() || num <= maxHeap.peek()){
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }

                // 균형 맞추기 (maxHeap이 1개 더 많거나 같도록)
                if(maxHeap.size() > minHeap.size() + 1){
                    minHeap.add(maxHeap.poll());
                } else if(minHeap.size() > maxHeap.size()){
                    maxHeap.add(minHeap.poll());
                }

                // 홀수 번째일 때 중앙값 출력
                if(i % 2 == 1){
                    sb.append(maxHeap.peek());
                    cnt++;

                    // 10개씩 출력 후 줄바꿈
                    if(cnt % 10 == 0){
                        sb.append("\n");
                    } else {
                        sb.append(" ");
                    }
                }
            }

            // 마지막에 줄바꿈이 없으면 추가
            if(cnt % 10 != 0){
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}