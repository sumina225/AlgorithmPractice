class Solution {
    public int solution(int[] arr) {
        int num = 1;

        while (true) {
            boolean check = true;

            for (int i = 0; i < arr.length; i++) {
                if (num % arr[i] != 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                return num;
            }

            num++;
        }
    }
}