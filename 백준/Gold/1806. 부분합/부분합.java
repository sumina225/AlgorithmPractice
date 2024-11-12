import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = nums[0], min = Integer.MAX_VALUE;

        while (end < n) {
            if (sum >= s) {
                min = Math.min(min, end - start + 1);  // 현재 윈도우 크기 계산
                sum -= nums[start];  // start를 증가시키며 sum에서 nums[start]를 빼기
                start++;  // start를 증가시켜 윈도우 크기 축소
            } else {
                end++;  // sum이 s보다 작은 경우, end를 증가시켜 합을 키움
                if (end < n) {
                    sum += nums[end];  // 새로운 end 값을 더함
                }
            }
        }

        // 만약 min이 Integer.MAX_VALUE로 남아있다면, 부분 수열을 찾을 수 없다는 의미
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);  // 부분 수열이 존재하지 않으면 0 출력
        } else {
            System.out.println(min);  // 최소 길이를 출력
        }
    }
}
