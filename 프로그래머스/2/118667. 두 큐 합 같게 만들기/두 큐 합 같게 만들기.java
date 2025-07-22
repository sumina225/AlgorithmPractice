import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        int len = queue1.length *2;
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        for(int i = 0; i < queue1.length; i++){
            sum = sum + (long)queue1[i] + (long)queue2[i];
            deque1.addLast(queue1[i]);
            deque2.addLast(queue2[i]);
            sum1 += (long)queue1[i];
            sum2 += (long)queue2[i];
        }
        if(sum % 2 == 1) return -1;
        sum /= 2;
        int max = len*2;
        while (sum1 != sum) {
            if (answer > max) {
                return -1;
            }

            if (sum1 > sum) {
                if (deque1.isEmpty()) { 
                    return -1;
                }
                int num = deque1.pollFirst();
                deque2.addLast(num);
                sum1 -= num;
                sum2 += num;
            }
            else {
                if (deque2.isEmpty()) {
                    return -1;
                }
                int num = deque2.pollFirst();
                deque1.addLast(num);
                sum2 -= num;
                sum1 += num;
            }
            answer++;
        }

        
        return answer;
    }
}