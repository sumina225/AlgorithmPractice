import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String,Integer> index = new HashMap<>();
        for(int i = 0; i < friends.length; i++){
            index.put(friends[i],i);
        }
        int[][] points = new int[friends.length][friends.length];
        for(int i = 0; i < gifts.length; i++){
            String[] trade = gifts[i].split(" ");
            points[index.get(trade[0])][index.get(trade[1])]++;
        }
        int[] totalPoint = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            for(int j = 0; j < friends.length; j++){
                totalPoint[i] = totalPoint[i] + points[i][j];
                totalPoint[i] = totalPoint[i] - points[j][i];
            }
        }
        for(int i = 0; i < friends.length; i++){
            int temp = 0;
            for(int j = 0; j < friends.length; j++){
                if(points[i][j] > points[j][i]){
                    temp++;
                }else if(points[i][j] == points[j][i]){
                    if(totalPoint[i] > totalPoint[j]){
                        temp++;
                    }
                }
            }
            if(answer < temp) answer = temp;
        }
        
        return answer;
    }
}