class Solution {
    
    static int answer;
    static boolean[] visited;
        
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        func(0,k,dungeons);
        return answer;
    }
    
    public void func(int count, int now, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= now){
                visited[i] = true;
                func(count+1, now-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}