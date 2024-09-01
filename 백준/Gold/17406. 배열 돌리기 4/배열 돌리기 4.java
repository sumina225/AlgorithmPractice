import java.io.*;
import java.util.*;

public class Main {
    static int[][] nums;
    static int k;
    static boolean[] visited;
    static Turn[] turns;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;
    
    static class Turn {
        int r, c, s;

        public Turn(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        turns = new Turn[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            turns[i] = new Turn(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        visited = new boolean[k];
        func(0);
        System.out.println(min);
    }
    
    public static void func(int depth) {
        if (depth == k) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += nums[i][j];
                }
                min = Math.min(sum, min);
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int[][] temp = deepCopy(nums);
                turn(turns[i]);
                func(depth + 1);
                nums = temp;  // 복원
                visited[i] = false;
            }
        }
    }
    
    public static void turn(Turn t) {
        int r = t.r - 1;
        int c = t.c - 1;
        int s = t.s;

        for (int i = 1; i <= s; i++) {
            Deque<Integer> temp = new ArrayDeque<>();
            int startX = c - i;
            int startY = r - i;
            int endX = c + i;
            int endY = r + i;

            // Top row
            for (int x = startX; x < endX; x++) {
                temp.add(nums[startY][x]);
            }

            // Right column
            for (int y = startY; y < endY; y++) {
                temp.add(nums[y][endX]);
            }

            // Bottom row
            for (int x = endX; x > startX; x--) {
                temp.add(nums[endY][x]);
            }

            // Left column
            for (int y = endY; y > startY; y--) {
                temp.add(nums[y][startX]);
            }

            temp.addFirst(temp.pollLast());  // Rotate

            // Top row
            for (int x = startX; x < endX; x++) {
                nums[startY][x] = temp.poll();
            }

            // Right column
            for (int y = startY; y < endY; y++) {
                nums[y][endX] = temp.poll();
            }

            // Bottom row
            for (int x = endX; x > startX; x--) {
                nums[endY][x] = temp.poll();
            }

            // Left column
            for (int y = endY; y > startY; y--) {
                nums[y][startX] = temp.poll();
            }
        }
    }

    public static int[][] deepCopy(int[][] array) {
        int[][] copy = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i].clone();
        }
        return copy;
    }
}
