import java.io.*;
import java.util.*;

public class Main {

    static class Player{
        int level;
        String name;

        public Player(int level, String name){
            this.level = level;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Player[][] room = new Player[300][m];
        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            cute : for(int j = 0; j < 300; j++){
                if(room[j][0] == null || Math.abs(room[j][0].level-l) <= 10){
                    if(room[i][m-1] != null) continue;
                    for(int k = 0; k < m; k++){
                        if(room[j][k] == null){
                            room[j][k] = new Player(l,n);
                            break cute;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 300; i++){
            if(room[i][0] == null) break;
            if(room[i][m-1] != null){
                sb.append("Started!").append("\n");
            }else{
                sb.append("Waiting!").append("\n");
            }
            Arrays.sort(room[i], new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    if(o1 == null || o2 == null){
                        return 0;
                    }
                    return o1.name.compareTo(o2.name);
                }
            });
            for(int j = 0; j < room[i].length; j++){
                if(room[i][j] == null) break;
                sb.append(room[i][j].level).append(" ").append(room[i][j].name).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
