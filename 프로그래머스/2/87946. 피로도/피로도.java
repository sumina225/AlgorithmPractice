import java.util.*;

class Solution {
    static int[] needEnergy;
    static int[] useEnergy;
    static boolean[] visited;
    static int num;
    static int answer = 0;

    public void dfs(int cnt, int remain) {
        for (int i = 0; i < num; i++) {
            if (!visited[i] && needEnergy[i] <= remain) {
                visited[i] = true;
                dfs(cnt + 1, remain - useEnergy[i]);
                visited[i] = false; // Backtrack
            }
        }
        answer = Math.max(answer, cnt);
        return;
    }

    public int solution(int k, int[][] dungeons) {
        num = dungeons.length;
        needEnergy = new int[num];
        useEnergy = new int[num];
        visited = new boolean[num];

        for (int i = 0; i < num; i++) {
            needEnergy[i] = dungeons[i][0];
            useEnergy[i] = dungeons[i][1];
        }

        dfs(0, k);
        return answer;
    }
}