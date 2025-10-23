import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>(); // {무게, 남은거리}
        int time = 0;
        int weight = 0;
        int index = 0;

        while (index < n || !queue.isEmpty()) {
            time++;

            // 1. 맨 앞 트럭 나갈 차례
            if (!queue.isEmpty() && queue.peek()[1] == 1) {
                weight -= queue.poll()[0];
            }

            // 2. 다리 위 트럭 이동 (남은거리 1 감소)
            for (int[] truck : queue) {
                truck[1]--;
            }

            // 3. 새로운 트럭 진입
            if (index < n && weight + nums[index] <= l) {
                queue.add(new int[]{nums[index], w});
                weight += nums[index];
                index++;
            }
        }

        System.out.println(time);
    }
}
