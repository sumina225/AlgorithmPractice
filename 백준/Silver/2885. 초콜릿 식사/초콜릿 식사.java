import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 1. K 이상인 가장 작은 2의 제곱수 찾기
        int size = 1;
        while (size < K) {
            size *= 2;
        }

        // 2. 쪼개는 횟수 계산
        // size - K의 이진수에서 1의 개수 + K의 이진수에서 1의 개수 - 1
        int split = Integer.bitCount(size - K) + Integer.bitCount(K) - 1;

        System.out.println(size + " " + split);
    }
}