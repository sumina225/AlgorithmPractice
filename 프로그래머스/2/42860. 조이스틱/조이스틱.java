class Solution {
    public int solution(String name) {
        // 1. 알파벳 변경 비용 계산
        int alphabetChangeCost = 0;
        for (char ch : name.toCharArray()) {
            // 'A'에서 해당 문자까지 가는 횟수
            int upMoves = ch - 'A';
            // 'Z'에서 해당 문자까지 가는 횟수 (+1은 'Z'에서 'A'로 가는 경우 포함)
            int downMoves = 'Z' - ch + 1;
            alphabetChangeCost += Math.min(upMoves, downMoves);
        }

        // 2. 커서 이동 비용 계산
        int n = name.length();
        // 초기 커서 이동 비용은 모든 문자를 오른쪽으로 쭉 가는 경우 (ex. "JAZ", 2번 이동)
        int minCursorMove = n - 1; 

        for (int i = 0; i < n; i++) {
            // 현재 문자 'i'가 'A'가 아니거나, 뒤에 'A'가 아닌 문자가 있다면
            // 'A'가 아닌 문자를 찾아서 커서를 이동해야 합니다.

            // 현재 위치 i 다음으로 연속되는 'A'의 개수 파악
            int nextNonA = i + 1;
            while (nextNonA < n && name.charAt(nextNonA) == 'A') {
                nextNonA++;
            }

            // 시나리오 1: 오른쪽으로 쭉 가서 현재 위치 i를 방문
            // 그리고 'A'가 아닌 다음 문자 nextNonA까지 이동
            // (n - nextNonA)는 문자열 끝에서 nextNonA까지 되돌아오는 거리
            // Math.min(i, n - nextNonA)는 i까지 갔다가 돌아오는 비용 vs 뒤에서부터 nextNonA까지 가는 비용 중 더 작은 것
            int currentCursorMove = i + (n - nextNonA) + Math.min(i, n - nextNonA);
            
            minCursorMove = Math.min(minCursorMove, currentCursorMove);
        }

        return alphabetChangeCost + minCursorMove;
    }
}