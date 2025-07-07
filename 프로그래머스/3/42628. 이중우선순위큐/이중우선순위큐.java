import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        for(int i = 0; i < operations.length; i++){
            String[] pair = operations[i].split(" ");
            if(pair[0].equals("I")){
                min.add(Integer.parseInt(pair[1]));
                max.add(Integer.parseInt(pair[1]));
            }else{
                if(min.isEmpty()) continue;
                
                if(pair[1].equals("-1")){
                    max.remove(min.poll());
                }else{
                    min.remove(max.poll());
                }
            }
        }
        if(min.isEmpty() && max.isEmpty()){
            answer = new int[]{0,0};
        }else{
            answer = new int[]{max.peek(),min.peek()};
        }
        return answer;
    }
}