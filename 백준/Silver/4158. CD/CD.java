import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            // 입력의 마지막인 0 0이 들어오면 루프를 종료합니다.
            if (n == 0 && m == 0) {
                break;
            }

            int[] sang = new int[n];
            for (int i = 0; i < n; i++) {
                sang[i] = Integer.parseInt(br.readLine());
            }

            int[] sun = new int[m];
            for (int i = 0; i < m; i++) {
                sun[i] = Integer.parseInt(br.readLine());
            }
            
            int answer = 0;
            
            // 문제에서 두 배열은 이미 정렬되어 있다고 명시되어 있으므로,
            // 이진 탐색 로직은 그대로 사용하면 됩니다.
            for (int i = 0; i < n; i++) {
                int low = 0;
                int high = m - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (sang[i] > sun[mid]) {
                        low = mid + 1;
                    } else if (sang[i] < sun[mid]) {
                        high = mid - 1;
                    } else {
                        answer++;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
        
        br.close();
    }
}