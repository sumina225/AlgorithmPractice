import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            Queue<Pos> fireQueue = new LinkedList<>();
            Queue<Pos> personQueue = new LinkedList<>();
            boolean[][] visited = new boolean[h][w];

            Pos start = null;
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@') {
                        start = new Pos(j, i);
                        personQueue.add(start);
                        visited[i][j] = true;
                    } else if (map[i][j] == '*') {
                        fireQueue.add(new Pos(j, i));
                    }
                }
            }

            boolean escaped = false;
            int time = 0;

            // BFS
            while (!personQueue.isEmpty()) {
                time++;

                // 불 먼저 확산
                int fireSize = fireQueue.size();
                for (int i = 0; i < fireSize; i++) {
                    Pos fire = fireQueue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = fire.x + dx[d];
                        int ny = fire.y + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                            if (map[ny][nx] == '.' || map[ny][nx] == '@') {
                                map[ny][nx] = '*';
                                fireQueue.offer(new Pos(nx, ny));
                            }
                        }
                    }
                }

                // 사람 이동
                int personSize = personQueue.size();
                for (int i = 0; i < personSize; i++) {
                    Pos person = personQueue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = person.x + dx[d];
                        int ny = person.y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                            // 탈출 성공
                            sb.append(time).append("\n");
                            escaped = true;
                            break;
                        }

                        if (!visited[ny][nx] && map[ny][nx] == '.') {
                            visited[ny][nx] = true;
                            personQueue.offer(new Pos(nx, ny));
                        }
                    }
                    if (escaped) break;
                }
                if (escaped) break;
            }

            if (!escaped) {
                sb.append("IMPOSSIBLE\n");
            }
        }

        System.out.println(sb.toString());
    }
}
