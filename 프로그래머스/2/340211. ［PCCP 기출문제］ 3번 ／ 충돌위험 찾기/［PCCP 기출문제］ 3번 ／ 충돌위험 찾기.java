import java.util.*;

class Solution {
    
    static class Pos{
        int r;
        int c;
        
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o){
            Pos pos = (Pos) o;
            return r == pos.r && c == pos.c;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(r,c);
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Integer,Pos> map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            map.put(i+1, new Pos(points[i][0],points[i][1]));
        }
        
        Pos[] position = new Pos[routes.length];
        int[] index = new int[routes.length];
        
        for(int i = 0; i < routes.length; i++){
            position[i] = new Pos(map.get(routes[i][0]).r,map.get(routes[i][0]).c);
        }
        while(true){
            boolean isDone = true;
            for(int i = 0; i < position.length; i++){
                if(!position[i].equals(map.get(routes[i][routes[i].length-1]))){
                    isDone = false;
                    break;
                }
            }
            if(isDone){
                break;
            }
            
            Set<Pos> now = new HashSet<>();
            Set<Pos> crash = new HashSet<>();
            for(int i = 0; i < position.length; i++){
                if(index[i] != routes[i].length){
                    if(position[i].r != map.get(routes[i][index[i]]).r){
                        if(position[i].r > map.get(routes[i][index[i]]).r){
                            position[i].r--;
                        }else{
                            position[i].r++;
                        }
                    }else{
                        if(position[i].c > map.get(routes[i][index[i]]).c){
                            position[i].c--;
                        }else if(position[i].c < map.get(routes[i][index[i]]).c){
                            position[i].c++;
                        }
                    }
                    if(position[i].equals(map.get(routes[i][index[i]]))){
                        index[i]++;
                    }
                    if(!now.contains(position[i])){
                        now.add(position[i]);
                    }else{
                        crash.add(position[i]);
                    }
                }
            }
            answer += crash.size();
            
        }
        
        return answer;
    }
}