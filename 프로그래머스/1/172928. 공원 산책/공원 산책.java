class Solution {
    static class Pos{
        int r;
        int c;
        
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        Pos now = null;
        cute : for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
               if(park[i].charAt(j) == 'S'){
                   now = new Pos(i,j);
                   break cute;
               } 
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String[] move = routes[i].split(" ");
            int len = Integer.parseInt(move[1]);
            int dr = 0, dc = 0;
            switch (move[0].charAt(0)) {
                case 'N': dr = -1; break;
                case 'S': dr =  1; break;
                case 'W': dc = -1; break;
                case 'E': dc =  1; break;
            }
            boolean ok = true;
            for (int step = 1; step <= len; step++) {
                int nr = now.r + dr * step;
                int nc = now.c + dc * step;
                if (nr < 0 || nr >= park.length || nc < 0 || nc >= park[0].length()
                        || park[nr].charAt(nc) == 'X') {
                    ok = false; break;
                }
            }
            if (ok) { now.r += dr * len; now.c += dc * len; }
        }
        return new int[]{now.r, now.c};
    }
}