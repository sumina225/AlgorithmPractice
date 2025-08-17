import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] > maxN) maxN = nums[i];
        }

        // 1) 에라토스테네스 체: O(N log log N)
        boolean[] isPrime = new boolean[maxN + 1];
        Arrays.fill(isPrime, true);
        if (maxN >= 0) isPrime[0] = false;
        if (maxN >= 1) isPrime[1] = false;

        for (int p = 2; p * p <= maxN; p++) {
            if (!isPrime[p]) continue;
            for (int m = p * p; m <= maxN; m += p) {
                isPrime[m] = false;
            }
        }

        // 2) 소수 리스트 미리 생성 → 쿼리 시 소수만 순회
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxN; i++) if (isPrime[i]) primes.add(i);

        // 3) 각 n에 대해 p ≤ n/2 인 소수만 보고 isPrime[n - p] 체크
        for (int n : nums) {
            int cnt = 0;
            for (int p : primes) {
                if (p > n / 2) break;
                if (isPrime[n - p]) cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
