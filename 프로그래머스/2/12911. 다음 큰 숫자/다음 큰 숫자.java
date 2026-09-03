class Solution {
    public int solution(int n) {
        int oneCount = Integer.bitCount(n);
        int answer = n + 1;

        while (Integer.bitCount(answer) != oneCount) {
            answer++;
        }

        return answer;
    }
}