class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        // n을 k진수 문자열로 변환
        String converted = Integer.toString(n, k);

        // 0이 하나 이상 연속되는 부분을 기준으로 분리
        String[] arr = converted.split("0+");

        for (String str : arr) {
            if (str.isEmpty()) {
                continue;
            }

            long num = Long.parseLong(str);

            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}