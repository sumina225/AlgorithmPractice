import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int colIndex = move - 1;

            for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
                if (board[rowIndex][colIndex] != 0) {
                    int doll = board[rowIndex][colIndex];

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }

                    board[rowIndex][colIndex] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}