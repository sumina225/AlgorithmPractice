import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pos{
        int num;
        int chon;
        public Pos(int num, int chon){
            this.num = num;
            this.chon = chon;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        boolean[] visited = new boolean[n+1];
        visited[a] = true;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(a,0));
        int answer = -1;
        cute : while(!queue.isEmpty()){
            Pos pos = queue.poll();
            for(int i = 0; i < list[pos.num].size(); i++){
                if(!visited[list[pos.num].get(i)]){
                    if(list[pos.num].get(i) == b){
                        answer = pos.chon+1;
                        break cute;
                    }
                    visited[list[pos.num].get(i)] = true;
                    queue.add(new Pos(list[pos.num].get(i),pos.chon+1));
                }
            }
        }
        System.out.println(answer);
    }
}