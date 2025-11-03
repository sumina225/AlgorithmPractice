import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] prev = new int[n]; // 경로 추적용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;      // 최소 길이 1
            prev[i] = -1;   // 이전 인덱스 없음
        }

        // LIS 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // 이전 인덱스 저장
                }
            }
        }

        // LIS 최대 길이 및 마지막 인덱스 찾기
        int maxLen = 0, lastIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // 경로 복원
        List<Integer> lis = new ArrayList<>();
        for (int i = lastIndex; i != -1; i = prev[i]) {
            lis.add(arr[i]);
        }
        Collections.reverse(lis); // 뒤집기

        // 출력
        System.out.println(maxLen);
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}
