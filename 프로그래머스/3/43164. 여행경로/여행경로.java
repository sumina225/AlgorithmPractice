import java.util.*;

class Solution {
    
    static int count;
    static boolean[] visited;
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        count = tickets.length;
        answer = new String[count+1];
        visited = new boolean[count];
        func(0,new String[count+1], tickets, "");
        
        return answer;
    }
    
    static void func(int depth, String[] result, String[][] tickets, String last){
        if(depth >= count){
            if(answer[0] == null){
                answer = result.clone();
            }else{
                for(int i = 0; i < count; i++){
                    if(answer[i].compareTo(result[i]) > 0){
                        answer = result.clone();
                        return;
                    }else if(answer[i].compareTo(result[i]) < 0){
                        return;
                    }
                }
            }
            return;
        }
        
        for(int i = 0; i < count; i++){
            if(depth == 0){
                if(tickets[i][0].equals("ICN")){
                    result[0] = "ICN";
                    result[1] = tickets[i][1];
                    visited[i] = true;
                    func(depth+1,result,tickets,tickets[i][1]);
                    visited[i] = false;
                }
            }else{
                if(!visited[i]){
                    if(tickets[i][0].equals(last)){
                        result[depth+1] = tickets[i][1];
                        visited[i] = true;
                        func(depth+1,result,tickets,tickets[i][1]);
                        visited[i] = false;
                    }
                }
            }
        }
        
    }
}