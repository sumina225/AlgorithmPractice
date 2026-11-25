
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        int[] freq = new int[101];
        int max = 0;

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            freq[num]++;
            max = Math.max(max, num);
        }

        int count = 0;

        while (max >= dasom) {
            if (freq[max] == 0) {
                max--;
                continue;
            }

            freq[max]--;
            freq[max - 1]++;
            dasom++;
            count++;
        }

        System.out.println(count);
    }
}
