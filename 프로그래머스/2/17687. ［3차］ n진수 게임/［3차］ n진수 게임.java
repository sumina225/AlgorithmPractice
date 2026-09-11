class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder all = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;

        while (all.length() < t * m) {
            all.append(Integer.toString(num, n).toUpperCase());
            num++;
        }

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(all.charAt(i));
        }

        return answer.toString();
    }
}