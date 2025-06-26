import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        char[] temp = new_id.toCharArray();
        List<Character> id = new ArrayList<>();
        for(int i = 0; i < temp.length; i++){
            id.add(temp[i]);
        }
        for(int i = 0; i < id.size(); i++){
            if(id.get(i) >= 'A' && id.get(i) <= 'Z'){
                char count = id.get(i);
                count = (char)(count - 'A' + 'a');
                id.set(i,count);
            }
        }
        for(int i = 0; i < id.size(); i++){
            if((id.get(i) >= 'a' && id.get(i) <= 'z') || (id.get(i) >= '0' && id.get(i)  <= '9') || id.get(i) == '-' || id.get(i) == '_' || id.get(i) == '.'){
                continue;
            }else{
                id.remove(i);
                i--;
            }
        }
        for(int i = 0; i < id.size(); i++){
            if(i < id.size()-1 && id.get(i) == '.' && id.get(i+1) == '.'){
                while(i < id.size()-1 && id.get(i+1) == '.'){
                    id.remove(i+1);
                }
            }
        }
        while(!id.isEmpty() && id.get(0) == '.'){
            id.remove(0);
        }
        while(!id.isEmpty() &&id.get(id.size()-1) == '.'){
            id.remove(id.size()-1);
        }
        if(id.isEmpty()){
            id.add('a');
        }
        if(id.size() >= 16){
            while(id.size() >= 16){
                id.remove(15);
            }
            if(!id.isEmpty() && id.get(id.size()-1) == '.'){
                id.remove(id.size()-1);
            }
        }
        while(id.size() <= 2){
            id.add(id.get(id.size()-1));
        }
        for(int i = 0; i < id.size(); i++){
            answer += id.get(i);
        }
        
        return answer;
    }
}