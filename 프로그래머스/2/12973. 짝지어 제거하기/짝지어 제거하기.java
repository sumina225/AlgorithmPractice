import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int num = 0;
        Deque<Character> deque = new ArrayDeque<>();
        while(num < s.length()) {
            if(!deque.isEmpty() && deque.peekLast() == s.charAt(num)){
                deque.pollLast();
            } else {
                deque.addLast(s.charAt(num));    
            }
            num++;
        }
        return deque.isEmpty() ? 1 : 0;
    }
}