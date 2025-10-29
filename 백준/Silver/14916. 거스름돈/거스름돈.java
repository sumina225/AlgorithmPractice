import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n >= 0) {
            if (n % 5 == 0) {       // 5로 나누어 떨어지는 경우
                count += n / 5;
                System.out.println(count);
                return;
            }
            n -= 2;  // 5로 안 나눠지면 2원을 하나씩 빼면서 확인
            count++;
        }

        System.out.println(-1); // 끝까지 안 맞으면 불가능
    }
}
