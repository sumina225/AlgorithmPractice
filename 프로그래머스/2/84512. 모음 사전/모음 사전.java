class Solution {
    static int count = 0;
    static int answer = 0;
    static String target;
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        target = word;

        dfs("");

        return answer;
    }

    private void dfs(String str) {
        if (str.length() == 5) {
            return;
        }

        for (char vowel : vowels) {
            String next = str + vowel;

            count++;

            if (next.equals(target)) {
                answer = count;
                return;
            }

            dfs(next);

            if (answer != 0) {
                return;
            }
        }
    }
}