class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] nums = new int[land.length][land[0].length];
        for(int i = 0; i < land[0].length; i++){
            nums[0][i] = land[0][i];
        }
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < land[i].length; j++){
                for(int k = 0; k < land[i].length; k++){
                    if(j == k){
                        continue;
                    }
                    nums[i][j] = Math.max(nums[i-1][k] + land[i][j], nums[i][j]);
                    if(i == land.length-1){
                        answer = Math.max(answer, nums[i][j]);
                    }
                }
            }
        }

        return answer;
    }
}