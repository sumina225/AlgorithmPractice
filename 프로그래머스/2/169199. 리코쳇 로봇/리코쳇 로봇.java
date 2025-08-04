import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        
        Point start = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new Point(i, j, 0);
                    break;
                }
            }
            if (start != null) break;
        }

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        q.offer(start);
        visited[start.x][start.y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Point current = q.poll();

            if (board[current.x].charAt(current.y) == 'G') {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x;
                int ny = current.y;
                
                while (true) {
                    int nextX = nx + dx[i];
                    int nextY = ny + dy[i];

                    if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || board[nextX].charAt(nextY) == 'D') {
                        break;
                    }
                    
                    nx = nextX;
                    ny = nextY;
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, current.count + 1));
                }
            }
        }
        
        return -1;
    }
}