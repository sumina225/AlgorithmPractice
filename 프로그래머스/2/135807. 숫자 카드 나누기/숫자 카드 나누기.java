import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 배열 A 전체의 gcd
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        // 배열 B 전체의 gcd
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int answer = 0;

        // gcdA가 arrayB의 원소 중 하나도 나누지 않으면 후보
        if (isValid(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }

        // gcdB가 arrayA의 원소 중 하나도 나누지 않으면 후보
        if (isValid(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    // 최대공약수 구하는 함수 (유클리드 호제법)
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // divisor가 다른 배열의 어떤 원소도 나누지 않는지 확인
    private boolean isValid(int divisor, int[] array) {
        for (int num : array) {
            if (num % divisor == 0) {
                return false; // 하나라도 나눠지면 실패
            }
        }
        return true;
    }
}
