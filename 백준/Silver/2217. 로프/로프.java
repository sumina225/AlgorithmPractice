import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ropes = new int[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순 정렬
        Arrays.sort(ropes);
        
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            // (n - i)개의 로프를 사용하는 경우
            int weight = ropes[i] * (n - i);
            maxWeight = Math.max(maxWeight, weight);
        }

        System.out.println(maxWeight);
    }
}
