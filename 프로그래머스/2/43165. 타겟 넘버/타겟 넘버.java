class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        func(0,target,numbers,0);
        return answer;
    }
    
    public void func(int index, int target, int[] numbers, int sum) {
        if(index == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        func(index+1, target, numbers, sum + numbers[index]);
        func(index+1, target, numbers, sum - numbers[index]);
    }
}