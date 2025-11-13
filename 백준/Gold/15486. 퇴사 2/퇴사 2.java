import java.io.*;
import java.util.*;

public class Main {

    static class Meet {
        int day, pay;
        public Meet(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meet[] meets = new Meet[n + 2]; // +1보다 +2로 하는 이유는 i+day가 n+1일 수 있어서

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            meets[i] = new Meet(day, pay);
        }

        int[] dp = new int[n + 2]; // dp[i]: i번째 날부터 끝까지 얻을 수 있는 최대 수익

        for (int i = n; i >= 1; i--) {
            if (i + meets[i].day <= n + 1) {
                dp[i] = Math.max(meets[i].pay + dp[i + meets[i].day], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1]; // 상담 못함 → 다음날로 넘김
            }
        }

        System.out.println(dp[1]);
    }
}
