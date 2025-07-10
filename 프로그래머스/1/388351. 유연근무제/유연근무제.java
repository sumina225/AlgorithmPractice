class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean[] check = new boolean[schedules.length];
        
        for(int i = 0; i < 7; i++){
            if((startday + i) % 7 == 6 || (startday + i) % 7 == 0){
                continue;
            }
            for(int j = 0; j < timelogs.length; j++){
                int time = (timelogs[j][i] / 100 * 60 + timelogs[j][i] % 100) -  (schedules[j] / 100 * 60 + schedules[j] % 100);
                
                if(time > 10){
                    check[j] = true;
                }
            }
        }
        for(int i = 0; i < check.length; i++){
            if(!check[i]){
                answer++;
            }
        }
        return answer;
    }
}