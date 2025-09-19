import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < P; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 번호
            int[] arr = new int[20]; // 키 저장
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int steps = 0; // 총 뒤로 물러선 횟수
            List<Integer> line = new ArrayList<>(); // 줄 서기

            for (int i = 0; i < 20; i++) {
                int student = arr[i];
                int pos = line.size(); // 기본적으로 맨 뒤

                // 자신보다 큰 학생이 있으면 그 앞에 끼어들 위치 찾기
                for (int j = 0; j < line.size(); j++) {
                    if (line.get(j) > student) {
                        pos = j;
                        break;
                    }
                }

                // 뒤로 밀린 학생 수 = line.size() - pos
                steps += (line.size() - pos);

                // 실제로 줄에 삽입
                line.add(pos, student);
            }

            // 출력
            System.out.println(T + " " + steps);
        }
    }
}
