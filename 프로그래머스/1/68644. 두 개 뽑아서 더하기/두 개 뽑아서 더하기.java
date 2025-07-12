import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sum = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                sum.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> temp = new ArrayList<>();
        for(int num : sum){
            temp.add(num);
        }
        Collections.sort(temp);
        int[] answer = new int[sum.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }
}