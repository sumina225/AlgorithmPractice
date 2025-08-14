import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        for(int i = 0; i < routes.length; i++){
            pq.add(routes[i]);
        }
        
        int cur = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[0] > cur){
                cur = temp[1];
                answer++;
            }
        }
        
        return answer;
    }
}