class Solution {
    public int[] solution(int[][] arr) {
        return compress(arr, 0, 0, arr.length);
    }

    // 재귀 함수: (x, y)는 시작 좌표, size는 정사각형 한 변의 길이
    private int[] compress(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        boolean same = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            // 모두 같으면 해당 숫자 하나만 유지
            int[] result = new int[2];
            result[first] = 1;
            return result;
        }

        // 압축되지 않으면 4등분해서 재귀 호출
        int newSize = size / 2;

        int[] topLeft = compress(arr, x, y, newSize);
        int[] topRight = compress(arr, x, y + newSize, newSize);
        int[] bottomLeft = compress(arr, x + newSize, y, newSize);
        int[] bottomRight = compress(arr, x + newSize, y + newSize, newSize);

        // 네 영역에서 반환된 0과 1의 개수 합산
        return new int[] {
            topLeft[0] + topRight[0] + bottomLeft[0] + bottomRight[0],
            topLeft[1] + topRight[1] + bottomLeft[1] + bottomRight[1]
        };
    }
}
