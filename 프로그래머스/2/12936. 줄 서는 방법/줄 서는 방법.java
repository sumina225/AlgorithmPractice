import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        // 아직 선택되지 않은 사람들의 번호를 저장하는 리스트
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // 팩토리얼 미리 계산 (n! 까지)
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        int[] answer = new int[n];
        k--; // k가 1부터 시작하므로, 0-based 인덱스로 맞춰줌
        
        // 각 자리(i)에 올 숫자를 결정
        for (int i = 0; i < n; i++) {
            // 현재 자리에서 한 숫자를 선택하면
            // 남은 (n - i - 1)! 만큼의 순열이 만들어짐
            long blockSize = fact[n - 1 - i];
            
            // k번째 순열이 속하는 블록의 index 계산
            int index = (int)(k / blockSize);
            
            // 해당 index에 있는 숫자를 선택
            answer[i] = numbers.get(index);
            
            // 선택한 숫자는 리스트에서 제거 (중복 방지)
            numbers.remove(index);
            
            // k를 현재 block 내에서의 위치로 갱신
            k %= blockSize;
        }
        
        return answer;
    }
}
