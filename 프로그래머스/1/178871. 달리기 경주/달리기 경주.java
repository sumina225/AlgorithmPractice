import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++){
            int idx = map.get(callings[i]);
            String temp = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = temp;
            map.put(players[idx-1], idx-1);
            map.put(players[idx], idx);
        }
        return players;
    }
}