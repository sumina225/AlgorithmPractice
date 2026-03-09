import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pos{
        int num;
        int count;
        public Pos(int num, int count){
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int j = 0; j < m; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Pos> queue = new LinkedList<>();
        int result = 0;
        queue.add(new Pos(1,0));
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            for(int i = 0; i < list[pos.num].size(); i++){
                if(pos.count <= 1 && !visited[list[pos.num].get(i)]){
                    result++;
                    visited[list[pos.num].get(i)] = true;
                    queue.add(new Pos(list[pos.num].get(i),pos.count+1));
                }
            }
        }
        System.out.println(result);
    }
}