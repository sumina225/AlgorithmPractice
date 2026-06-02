import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        for(int i = 0; i < wires.length; i++){
            List<Integer>[] list = new ArrayList[n + 1];
            for(int j = 1; j <= n; j++){
                list[j] = new ArrayList<>();
            }
            for(int j = 0; j < wires.length; j++){
                if(j == i) continue;
                list[wires[j][0]].add(wires[j][1]);
                list[wires[j][1]].add(wires[j][0]);
            }
            boolean[] visited = new boolean[n + 1];
            int num1 = 0;
            for(int j = 1; j < n + 1; j++){
                if(!visited[j]){
                    int count = 1;
                    visited[j] = true;
                    Deque<Integer> deque = new ArrayDeque<>();
                    deque.add(j);
                    while(!deque.isEmpty()){
                        int num = deque.poll();
                        for(int k = 0; k < list[num].size(); k++){
                            int temp = list[num].get(k);
                            if(!visited[temp]){
                                count++;
                                visited[temp] = true;
                                deque.add(temp);
                            }
                        }
                    }
                    num1 = count;
                    break;
                }
            }
            if(answer == -1) {
                answer = Math.abs(n - 2 * num1);
            } else {
                answer = Math.min(answer, Math.abs(n - 2 * num1));
            }
        }
        return answer;
    }
}