import java.util.*;

class Solution {
    
    static class Truck{
        int weight;
        int time;
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        Queue<Truck> queue = new LinkedList<>();
        int w = 0;
        
        while(index < truck_weights.length || !queue.isEmpty()){
            answer++;
            
            while(!queue.isEmpty() && answer - queue.peek().time >= bridge_length){
                Truck temp = queue.poll();
                w -= temp.weight;
            }
            if(index < truck_weights.length && w + truck_weights[index] <= weight){
                Truck truck = new Truck();
                truck.weight = truck_weights[index];
                truck.time = answer;
                queue.add(truck);
                w += truck.weight;
                index++;
            }
            
        }
        return answer;
    }
}