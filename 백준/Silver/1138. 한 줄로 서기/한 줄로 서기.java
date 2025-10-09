import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> line = new ArrayList<>();

        // 키가 1인 사람부터 차례대로 줄 세우기
        for (int i = n - 1; i >= 0; i--) {
            // 뒤에서부터 삽입해야 인덱스가 밀리지 않음
            line.add(nums[i], i + 1);
        }

        // 출력
        for (int i = 0; i < n; i++) {
            sb.append(line.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
