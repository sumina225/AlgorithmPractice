import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        while (n > 0) {
            int temp = n;
            int digit = 0;

            // 자릿수 계산
            while (temp > 0) {
                temp /= 10;
                digit++;
            }

            answer += digit;
            n--;
        }

        System.out.println(answer);
    }
}
