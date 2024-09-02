import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static int ans; // 최대값을 저장할 변수
    static ArrayList<Character> ops; // 연산자를 저장할 리스트
    static ArrayList<Integer> nums; // 숫자를 저장할 리스트

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 입력을 받기 위한 BufferedReader와 결과 출력을 위한 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수식의 길이 입력 받기
        String input = br.readLine(); // 수식 문자열 입력 받기

        ops = new ArrayList<>(); // 연산자를 저장할 리스트 초기화
        nums = new ArrayList<>(); // 숫자를 저장할 리스트 초기화

        // 수식 문자열을 읽어 연산자와 숫자를 분리하여 리스트에 저장
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c); // 연산자는 ops 리스트에 추가
                continue;
            }
            nums.add(Character.getNumericValue(c)); // 숫자는 nums 리스트에 추가
        }

        ans = Integer.MIN_VALUE; // 최대값 초기화
        DFS(nums.get(0), 0); // DFS를 통해 최대값 찾기

        // 결과를 출력
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 두 숫자와 연산자로 계산을 수행하는 함수
    public static int calc(char op, int n1, int n2) {
        switch (op) {
        case '+':
            return n1 + n2; // 더하기 연산
        case '-':
            return n1 - n2; // 빼기 연산
        case '*':
            return n1 * n2; // 곱하기 연산
        }
        return -1; // 유효하지 않은 연산자 처리
    }

    // DFS와 백트래킹을 사용하여 가능한 모든 괄호 조합을 탐색
    public static void DFS(int result, int opIdx) {
        // 모든 연산자를 사용했거나 인덱스가 범위를 초과했을 때
        if (opIdx >= ops.size()) {
            ans = Math.max(ans, result); // 최대값 갱신
            return;
        }

        // 괄호를 사용하지 않은 경우
        int res1 = calc(ops.get(opIdx), result, nums.get(opIdx + 1));
        DFS(res1, opIdx + 1); // 다음 연산자로 진행

        // 괄호를 사용하는 경우
        if (opIdx + 1 < ops.size()) {
            // 현재 연산자의 오른쪽에 있는 두 숫자를 연산
            int res2 = calc(ops.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));

            // 현재 연산자와 괄호 안의 연산 결과를 연산
            DFS(calc(ops.get(opIdx), result, res2), opIdx + 2);
        }
    }
}
