import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // ⌈9M/10⌉
        int low = (int)((9L * m + 9) / 10);

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        // 초기 윈도우
        for (int i = 0; i < m; i++) {
            int v = nums[i];
            int c = map.getOrDefault(v, 0) + 1; // 공통 증가
            if (c >= low) { System.out.println("YES"); return; } // 바로 체크
            map.put(v, c);
        }

        // 슬라이딩
        for (int start = 1; start <= n - m; start++) {
            int left = nums[start - 1];
            int c = map.get(left) - 1;
            if (c == 0) map.remove(left); else map.put(left, c);

            int right = nums[start + m - 1];
            c = map.getOrDefault(right, 0) + 1; // 공통 증가
            if (c >= low) { System.out.println("YES"); return; } // 바로 체크
            map.put(right, c);
        }

        System.out.println("NO");
    }
}
