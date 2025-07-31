import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        func(begin,target,words,0);
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        return answer;
    }
    
    static void func(String now, String target, String[] words, int count){
        if(count >= answer){
            return;
        }
        if(now.equals(target)){
            if(answer > count){
                answer = count;
            }
            return;
        }
        for(int i = 0; i < words.length; i++){
            int diff = 0;
            for(int j = 0; j < words[i].length(); j++){
                if(now.charAt(j) != words[i].charAt(j)){
                    diff++;
                }
                if(diff > 1) break;
            }
            if(diff == 1){
                if(!visited[i]){
                    visited[i] = true;
                    func(words[i],target,words,count+1);
                    visited[i] = false;
                }
            }
        }
    }
}