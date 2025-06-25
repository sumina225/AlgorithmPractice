class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int goalNum = 0;
        int num1 = 0;
        int num2 = 0;
        while(goalNum < goal.length){
            if(num1 < cards1.length && goal[goalNum].equals(cards1[num1])){
                num1++;
                goalNum++;
            }else if(num2 < cards2.length && goal[goalNum].equals(cards2[num2])){
                num2++;
                goalNum++;
            }else{
                return "No";
            }
        }
        return answer;
    }
}