import java.util.*;

class Solution {
    
    static class Road {
        int s;
        int e;
        int cost;

        public Road(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }

    static int[] parent;

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a; // 두 집합 합치기
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 부모 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 비용 기준으로 정렬
        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for (int[] cost : costs) {
            pq.add(new Road(cost[0], cost[1], cost[2]));
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Road road = pq.poll();

            // 사이클이 생기지 않는 경우만 선택
            if (find(road.s) != find(road.e)) {
                union(road.s, road.e);
                answer += road.cost;
                count++;
            }

            // MST는 n-1개의 간선만 필요
            if (count == n - 1) break;
        }

        return answer;
    }
}
