import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c: number.toCharArray()){
            while(k > 0 && !stack.isEmpty() && stack.peek() < c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            answer = stack.peek() + answer;
            stack.pop();
        }
        return answer;
    }
}