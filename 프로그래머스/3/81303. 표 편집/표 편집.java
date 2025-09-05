import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 각 행의 이전/다음 행을 가리키는 배열 (연결리스트 구조)
        int[] prev = new int[n + 2]; // 더미 노드 포함
        int[] next = new int[n + 2];
        
        // 초기 연결리스트 설정 (0: head dummy, n+1: tail dummy)
        for(int i = 0; i <= n + 1; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        // 현재 위치를 실제 노드로 설정
        int current = k + 1; // 1-based indexing (0은 더미)
        
        Stack<Integer> deleted = new Stack<>();
        
        for(String command : cmd){
            String[] ss = command.split(" ");
            
            if(ss[0].equals("D")){
                // 아래로 이동
                int steps = Integer.parseInt(ss[1]);
                for(int i = 0; i < steps; i++){
                    current = next[current];
                }
            }
            else if(ss[0].equals("U")){
                // 위로 이동
                int steps = Integer.parseInt(ss[1]);
                for(int i = 0; i < steps; i++){
                    current = prev[current];
                }
            }
            else if(ss[0].equals("C")){
                // 현재 행 삭제
                deleted.push(current);
                
                // 연결리스트에서 제거
                next[prev[current]] = next[current];
                prev[next[current]] = prev[current];
                
                // 커서 이동
                if(next[current] <= n){ // 다음 행이 존재하면
                    current = next[current];
                } else { // 마지막 행이었다면 이전 행으로
                    current = prev[current];
                }
            }
            else if(ss[0].equals("Z")){
                // 가장 최근 삭제된 행 복원
                if(!deleted.isEmpty()){
                    int restore = deleted.pop();
                    
                    // 연결리스트에 다시 삽입
                    next[prev[restore]] = restore;
                    prev[next[restore]] = restore;
                }
            }
        }
        
        // 결과 문자열 생성
        boolean[] exists = new boolean[n];
        int node = next[0]; // 첫 번째 실제 노드부터 시작
        while(node <= n){
            exists[node - 1] = true; // 0-based로 변환
            node = next[node];
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            answer.append(exists[i] ? 'O' : 'X');
        }
        
        return answer.toString();
    }
}