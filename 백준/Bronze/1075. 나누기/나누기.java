import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int base = (N / 100) * 100; // 마지막 두 자리를 00으로 만듦
        int answer = 0;

        for (int i = 0; i < 100; i++) {
            if ((base + i) % F == 0) {
                answer = i;
                break;
            }
        }

        // 두 자리로 출력 (예: 01, 07)
        System.out.printf("%02d\n", answer);
    }
}
