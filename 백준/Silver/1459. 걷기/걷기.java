import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        // 방법 1: 직선만 사용
        long time1 = (x + y) * w;

        // 방법 2: 대각선을 최대한 사용
        // min(x,y)번 대각선 이동 후, |x-y|번 직선 이동
        long minXY = Math.min(x, y);
        long time2 = minXY * s + Math.abs(x - y) * w;

        // 방법 3: 지그재그 패턴 (대각선과 반대 대각선 번갈아 사용)
        long maxXY = Math.max(x, y);
        long time3;
        if ((x + y) % 2 == 0) {
            // 차이가 짝수: 지그재그로 max좌표까지 도달 가능
            time3 = maxXY * s;
        } else {
            // 차이가 홀수: max-1까지 대각선, 마지막 1칸은 직선
            time3 = (maxXY - 1) * s + w;
        }

        // 세 가지 방법 중 최소값
        long answer = Math.min(time1, Math.min(time2, time3));
        System.out.println(answer);
    }
}