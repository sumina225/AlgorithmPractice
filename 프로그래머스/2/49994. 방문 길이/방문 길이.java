class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        // 상하좌우순으로
        // start는 5,5
        int r = 5;
        int c = 5;
        for(int i = 0; i < dirs.length(); i++){
            char cc = dirs.charAt(i);
            int nr = r;
            int nc = c;
            if(cc == 'U'){
                nr++;
            }else if(cc == 'D'){
                nr--;
            }else if(cc == 'L'){
                nc--;
            }else if(cc == 'R'){
                nc++;
            }
            if(nr < 0 || nr > 10 || nc < 0 || nc > 10){
                nr = r;
                nc = c;
            }else{
                if(cc == 'U'){
                    if(!visited[r][c][0]){
                        visited[r][c][0] = true;
                        visited[nr][nc][1] = true;
                        answer++;
                    }
                }else if(cc == 'D'){
                    if(!visited[r][c][1]){
                        visited[r][c][1] = true;
                        visited[nr][nc][0] = true;
                        answer++;
                    }
                }else if(cc == 'L'){
                    if(!visited[r][c][2]){
                        visited[r][c][2] = true;
                        visited[nr][nc][3] = true;
                        answer++;
                    }
                }else if(cc == 'R'){
                    if(!visited[r][c][3]){
                        visited[r][c][3] = true;
                        visited[nr][nc][2] = true;
                        answer++;
                    }
                }
                r = nr;
                c = nc;
            }
        }
        return answer;
    }
}