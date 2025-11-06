import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int inc = 1;  // 연속 비감소 구간 길이
        int dec = 1;  // 연속 비증가 구간 길이
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                inc++;
            } else {
                inc = 1;
            }

            if (nums[i] <= nums[i - 1]) {
                dec++;
            } else {
                dec = 1;
            }

            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }

        System.out.println(maxLen);
    }
}
