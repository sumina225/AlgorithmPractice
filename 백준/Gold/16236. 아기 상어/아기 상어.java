import java.io.*;
import java.util.*;

class Shark {
    public int x;
    public int y;
    public int dist;

    public Shark(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][n];
        int babyx = 0;
        int babyy = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                if (nums[i][j] == 9) {
                    babyx = j;
                    babyy = i;
                    nums[i][j] = 0; // 아기 상어의 위치는 0으로 초기화
                }
            }
        }

        int eat = 0;
        int result = 0;
        int size = 2;

        while (true) {
            PriorityQueue<Shark> sharks = new PriorityQueue<>(new Comparator<Shark>() {
                @Override
                public int compare(Shark a, Shark b) {
                    if (a.dist == b.dist) {
                        if (a.y == b.y) return a.x - b.x; // x 좌표가 작은 순으로
                        return a.y - b.y; // y 좌표가 작은 순으로
                    }
                    return a.dist - b.dist; // 거리 순으로
                }
            });

            boolean[][] visited = new boolean[n][n];
            sharks.add(new Shark(babyx, babyy, 0));
            visited[babyy][babyx] = true;
            boolean found = false;

            while (!sharks.isEmpty()) {
                Shark temp = sharks.poll();
                int dy[] = {-1, 0, 0, 1};
                int dx[] = {0, -1, 1, 0};
                
                if(nums[temp.y][temp.x] != 0 && nums[temp.y][temp.x] < size) {
                	nums[temp.y][temp.x] = 0;
                	eat++;
                	result += temp.dist;
                	found = true;
                	babyx = temp.x;
                    babyy = temp.y;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx]) {
                        if (nums[ny][nx] <= size) { // 상어가 지나갈 수 있는 위치
                            visited[ny][nx] = true;
                            sharks.add(new Shark(nx, ny, temp.dist + 1));
                        }
                    }
                }

                if (found) break;
            }

            if (!found) break; // 더 이상 먹을 물고기가 없으면 종료

            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(result);
    }
}
