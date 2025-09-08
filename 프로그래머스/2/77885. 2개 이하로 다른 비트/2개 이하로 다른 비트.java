import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            
            // 짝수면 그냥 +1
            if ((x & 1) == 0) {
                answer[i] = x + 1;
            } else {
                // 홀수일 때: (x + 1) | (((x ^ (x + 1)) >> 2))
                // -> 비트 연산으로 오른쪽에서 첫 0을 찾아 바꾸는 트릭
                answer[i] = x + 1 + (((x ^ (x + 1)) >> 2));
            }
        }
        
        return answer;
    }
}
