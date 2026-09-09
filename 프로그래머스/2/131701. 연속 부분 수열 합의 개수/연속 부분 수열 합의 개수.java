import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] nums = new int[elements.length*2];
        for(int i = 0; i < elements.length; i++){
            nums[i] = elements[i];
            nums[i + elements.length] = elements[i];
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int sum = 0;
                for(int k = 0; k < i; k++){
                    sum += nums[j+k];
                }
                set.add(sum);
            }
            
        }
        return set.size();
    }
}