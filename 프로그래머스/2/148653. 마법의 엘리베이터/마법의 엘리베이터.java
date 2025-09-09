class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10; // 현재 자리 수
            int next = (storey / 10) % 10; // 다음 자리 수
            
            if (digit > 5) {
                // 6~9일 경우 올리는 게 더 이득
                answer += (10 - digit);
                storey += 10; // 자리 올림
            } else if (digit < 5) {
                // 0~4일 경우 그냥 내리는 게 이득
                answer += digit;
            } else {
                // digit == 5 인 경우 -> 다음 자리 기준
                if (next >= 5) {
                    answer += 5;
                    storey += 10; // 올림
                } else {
                    answer += 5;
                }
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
