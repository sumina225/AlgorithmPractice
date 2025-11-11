import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 파일 개수
        long[] sizes = new long[N];
        for (int i = 0; i < N; i++) {
            sizes[i] = sc.nextLong(); // 각 파일 크기
        }
        long cluster = sc.nextLong(); // 클러스터 크기

        long total = 0;

        for (long size : sizes) {
            if (size == 0) continue; // 크기가 0이면 디스크 공간 사용 X
            long used = ((size + cluster - 1) / cluster) * cluster;
            total += used;
        }

        System.out.println(total);
    }
}
