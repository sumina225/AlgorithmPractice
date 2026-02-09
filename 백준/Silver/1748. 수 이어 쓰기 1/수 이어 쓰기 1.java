import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = 0;
        long start = 1;
        int len = 1;

        while (start <= N) {
            long end = start * 10 - 1;
            if (end > N) end = N;

            answer += (end - start + 1) * len;

            start *= 10;
            len++;
        }

        System.out.println(answer);
    }
}
