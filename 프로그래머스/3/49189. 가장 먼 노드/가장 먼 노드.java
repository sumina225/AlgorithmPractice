import java.util.*;

class Solution {
    
    static int[] dp;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        List<Integer>[] list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++){
            list[edge[i][0]-1].add(edge[i][1]-1);
            list[edge[i][1]-1].add(edge[i][0]-1);
        }
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0,0});
        while(!q.isEmpty()){
            Integer[] num = q.poll();
            if(dp[num[0]] > num[1]){
                dp[num[0]] = num[1];
            }else{
                continue;
            }
            for(int i = 0; i < list[num[0]].size(); i++){
                q.add(new Integer[]{list[num[0]].get(i),num[1]+1});
            }
        }
        Arrays.sort(dp);
        int max = dp[n-1];
        for(int i = n-1; i >= 0; i--){
            if(dp[i] == max) answer++;
            else break;
        }
        return answer;
    }
}