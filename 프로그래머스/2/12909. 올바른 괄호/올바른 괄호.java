class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int[] nums = new int[2];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                nums[0]++;
            } else {
                nums[1]++;
            }
            if(nums[1] > nums[0]){
                answer = false;
                break;
            }
        }
        if(nums[0] != nums[1]){
            answer = false;
        }
        return answer;
    }
}