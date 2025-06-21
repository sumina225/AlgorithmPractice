import java.util.*;

class Solution {
    
    static int len;
    static int answer;
    static boolean[] visited;
    static Set<Integer> nums;
    
    public int solution(String numbers) {
        answer = 0;
        len = numbers.length();
        visited = new boolean[len];
        nums = new HashSet<>();
        func(numbers,"",0);
        return answer;
    }
    
    static void func(String numbers, String temp, int depth){
        if(depth == len){
            if(temp.equals("")) return;
            int num = Integer.parseInt(temp);
            if(nums.contains(num)) return;
            if(num < 2) return;
            for(int i = 2; i < num; i++){
                if(num % i == 0){
                    return;
                }
            }
            nums.add(num);
            answer++;
            return;
        }
        for(int i = 0; i < len; i++){
            if(!visited[i]){
                visited[i] = true;
                func(numbers,temp + numbers.charAt(i),depth+1);
                visited[i] = false;
            }
        }
        func(numbers,temp,depth+1);
    }
}