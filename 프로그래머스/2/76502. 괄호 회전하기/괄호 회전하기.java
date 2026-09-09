import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean isPossible = true;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt((i + j) % s.length());

                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    }

                    char top = stack.pop();

                    if (c == ')' && top != '(') {
                        isPossible = false;
                        break;
                    }

                    if (c == '}' && top != '{') {
                        isPossible = false;
                        break;
                    }

                    if (c == ']' && top != '[') {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible && stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}