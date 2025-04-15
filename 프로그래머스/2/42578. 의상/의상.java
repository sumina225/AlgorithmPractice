import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],1);
            }else{
                int temp = map.get(clothes[i][1]);
                map.replace(clothes[i][1],temp+1);
            }
        }
        for(int i : map.values()){
            answer *= i+1;
        }
        answer -= 1;
        return answer;
    }
}