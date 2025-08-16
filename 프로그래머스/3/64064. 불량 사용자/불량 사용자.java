import java.util.*;

class Solution {
    
    Set<String> uniqueSets = new HashSet<>();
    List<Integer>[] cand;
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        cand = new ArrayList[banned_id.length];
        for(int i = 0; i < banned_id.length; i++){
            cand[i] = new ArrayList<>();
            for(int j = 0; j < user_id.length; j++){
                if(user_id[j].length() != banned_id[i].length()) continue;
                boolean ok = true;
                for(int k = 0; k < user_id[j].length(); k++){
                    char c = banned_id[i].charAt(k);
                    if(c != '*' && c != user_id[j].charAt(k)){
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    cand[i].add(j);
                }
            }
        }
        visited = new boolean[user_id.length];
        dfs(0);
        return uniqueSets.size();
    }
    
    private void dfs(int depth){
        if(depth == cand.length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    sb.append(i).append(',');
                }
            }
            uniqueSets.add(sb.toString());
            return;
        }
        for(int user : cand[depth]){
            if(visited[user]) continue;
            visited[user] = true;
            dfs(depth+1);
            visited[user] = false;
        }
    }
}