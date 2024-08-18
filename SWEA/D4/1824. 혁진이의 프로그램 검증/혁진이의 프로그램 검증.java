import java.io.*;
import java.util.*;

public class Solution {
    public static int[] dx = { -1, 1, 0, 0 }; // 좌 우 상 하
    public static int[] dy = { 0, 0, -1, 1 };
    public static int r;
    public static int c;
    
    static class Frame {
        int x, y, dir, memory;

        Frame(int x, int y, int dir, int memory) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.memory = memory;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            char[][] nums = new char[r][c];
            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                nums[i] = s.toCharArray();
            }
            boolean[][][][] visited = new boolean[r][c][16][4];
            if (bfs(0, 0, 1, visited, nums)) {
                System.out.println("#" + t + " YES");
            } else {
                System.out.println("#" + t + " NO");
            }
        }
    }

    public static boolean bfs(int startX, int startY, int startDir, boolean[][][][] visited, char[][] nums) {
        Queue<Frame> queue = new LinkedList<>();
        queue.add(new Frame(startX, startY, startDir, 0));

        while (!queue.isEmpty()) {
            Frame current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dir = current.dir;
            int memory = current.memory;

            if (visited[y][x][memory][dir]) {
                continue;
            }
            visited[y][x][memory][dir] = true;

            char command = nums[y][x];
            if (command == '@') {
                return true;
            } else if (command == '<') {
                dir = 0;
            } else if (command == '>') {
                dir = 1;
            } else if (command == '^') {
                dir = 2;
            } else if (command == 'v') {
                dir = 3;
            } else if (command == '_') {
                dir = (memory == 0) ? 1 : 0;
            } else if (command == '|') {
                dir = (memory == 0) ? 3 : 2;
            } else if (command == '?') {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0) nx = c - 1;
                    else if (nx >= c) nx = 0;
                    if (ny < 0) ny = r - 1;
                    else if (ny >= r) ny = 0;
                    queue.offer(new Frame(nx, ny, i, memory));
                }
                continue;
            } else if (command == '+') {
                memory = (memory + 1) % 16;
            } else if (command == '-') {
                memory = (memory - 1 + 16) % 16;
            } else if (Character.isDigit(command)) {
                memory = command - '0';
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0) nx = c - 1;
            else if (nx >= c) nx = 0;
            if (ny < 0) ny = r - 1;
            else if (ny >= r) ny = 0;

            queue.offer(new Frame(nx, ny, dir, memory));
        }
        return false;
    }
}
