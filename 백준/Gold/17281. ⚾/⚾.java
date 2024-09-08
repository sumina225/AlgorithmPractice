import java.util.*;
import java.io.*;

public class Main {
    
    static int inning; // 총 이닝 수
    static int[][] playerStat; // 각 이닝별로 선수의 능력치 (타율 등)
    
    static boolean[] isPlayerChecked; // 선수 조합을 위한 체크 배열
    static int[] lineUp; // 선수 순서 배열 (각 타자에 대한 선수 번호를 저장)
    
    static Queue<Integer> que; // (사용되지 않음) 야구에서 베이스를 의미하는 큐
    static int out; // 현재 이닝에서의 아웃 횟수
    
    static int max = -1; // 최대 점수 기록 변수
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 이닝 수 입력 받기
        inning = Integer.parseInt(br.readLine());
        
        // 선수의 이닝별 능력치를 저장할 배열 초기화
        playerStat = new int[inning][10];
        for(int i = 0; i < inning; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= 9; j++) {
                playerStat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 선수 순서 조합을 위한 배열 초기화
        isPlayerChecked = new boolean[10];
        lineUp = new int[10];
        
        // 4번 타자에 1번 선수를 미리 고정
        lineUp[4] = 1;
        isPlayerChecked[4] = true;
        
        // 나머지 2번부터 9번 선수의 조합을 찾아보는 함수 호출
        playerSeq(2);
        
        // 최대 점수를 출력
        System.out.println(max);
    }
    
    // 선수 순서 조합 함수
    static void playerSeq(int num) {
        // 9명 모두 조합이 완료되면 플레이
        if(num == 10) {
            int score = play();
            max = Math.max(max, score);
            return;
        }
        
        // 현재 선수를 1번 자리부터 9번 자리까지 넣어보며 재귀 호출
        for(int i = 1; i <= 9; i++) {
            if(!isPlayerChecked[i]) {
                isPlayerChecked[i] = true;
                lineUp[i] = num;
                playerSeq(num + 1);
                isPlayerChecked[i] = false;
            }
        }
    }
    
    // 게임 플레이 함수
    static int play() {
        int sum = 0;
        
        int idx = 1; // 타자 순서 시작 (1번 타자부터 시작)
        for(int r = 0; r < inning; r++) {
            int inningScore = 0; // 현재 이닝에서 얻는 점수
            out = 0; // 현재 이닝에서 아웃 횟수 초기화
            boolean[] base = new boolean[4]; // 베이스 상태를 나타내는 배열 (0: 출루 없음, 1: 1루, 2: 2루, 3: 3루)
            
            // 3 아웃이 되기 전까지 반복
            while(out < 3) {
                switch(playerStat[r][lineUp[idx]]) {
                    // 아웃
                    case 0:
                        out++;
                        break;
                    // 1루타
                    case 1:
                        if(base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if(base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if(base[1]) {
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    // 2루타
                    case 2:
                        if(base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if(base[2]) {
                            inningScore++;
                        }
                        if(base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    // 3루타
                    case 3:
                        if(base[3]) {
                            inningScore++;
                        }
                        if(base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    // 홈런
                    case 4:
                        if(base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if(base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        inningScore++;
                        break;
                }
                
                // 다음 타자로 이동
                idx++;
                // 10번 타자까지 갔다면 다시 1번 타자로 돌아감
                if(idx >= 10) {
                    idx = 1;
                }
            }
            
            // 현재 이닝에서 얻은 점수를 총 게임 점수에 더함
            sum += inningScore;
        }
        
        // 총 게임에서 얻은 점수 반환
        return sum;
    }
}
