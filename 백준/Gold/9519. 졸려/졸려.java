import java.io.*;
import java.util.*;

public class Main {
    static int x; // 눈을 깜박인 횟수
    static List<String> list = new ArrayList<>(); // 변형된 문자열을 저장할 리스트
    static String s; // 원래 문자열
    static List<String> changeList = new ArrayList<>(); // 변형된 문자열 기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine()); // 첫 번째 줄: 깜박인 횟수
        s = br.readLine(); // 두 번째 줄: 변형된 문자열

        // 문자열의 각 문자를 리스트에 추가
        for(int i = 0; i < s.length(); i++) {
            list.add(s.substring(i, i + 1)); // 문자열의 각 문자 추출하여 리스트에 저장
        }
        changeList.add(s); // 초기 변형된 문자열을 기록

        // 중간 위치 계산
        int moveCnt = 0;
        if(s.length() % 2 == 0) {
            moveCnt = s.length() / 2 - 1; // 문자열 길이가 짝수일 경우
        } else {
            moveCnt = s.length() / 2; // 문자열 길이가 홀수일 경우
        }

        int cnt = 0; // 변형 횟수 카운터
        boolean cal = false; // 원래 문자열을 찾았는지 여부
        while(cnt < x) { // x 횟수만큼 반복
            // 문자를 뒤에서부터 앞으로 이동
            for(int i = 2 * moveCnt - 1; i >= 0; i -= 2) {
                String move = list.get(i); // 이동할 문자 저장
                list.remove(i); // 리스트에서 해당 문자 제거
                list.add(move); // 리스트 끝에 추가하여 이동 효과 발생
            }
            cnt++; // 변형 횟수 증가

            // 리스트가 원래 문자열과 동일한지 확인
            if(check()) {
                cal = true; // 동일하다면 원래 문자열을 찾음
                break; // 반복 종료
            }
            changeList.add(String.join("", list)); // 변형된 문자열을 기록
        }
        
        // 원래 문자열을 찾았으면 해당 인덱스의 문자열을 출력
        if(cal) {
            System.out.println(changeList.get(x % cnt)); // 주기의 길이로 나눈 나머지
        } else {
            // 주기를 찾지 못한 경우, 마지막 변형된 문자열 출력
            System.out.println(changeList.get(changeList.size() - 1));
        }
    }
    
    // 현재 리스트의 문자열이 원래 문자열과 동일한지 확인하는 메서드
    static boolean check() {
        for(int i = 0; i < s.length(); i++) {
            if(!s.substring(i, i + 1).equals(list.get(i))) {
                return false; // 동일하지 않으면 false 반환
            }
        }
        return true; // 모두 동일하면 true 반환
    }
}
