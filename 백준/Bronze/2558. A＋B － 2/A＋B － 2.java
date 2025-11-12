import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringBuilder는 출력 성능 향상용
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄 입력
        int A = Integer.parseInt(br.readLine());

        // 두 번째 줄 입력
        int B = Integer.parseInt(br.readLine());

        // 결과 계산
        int sum = A + B;

        // 결과를 StringBuilder에 추가
        sb.append(sum);

        // 출력
        System.out.println(sb.toString());
    }
}
