import java.util.*;

class Solution {
    
    static class Price{
        int price;
        int idx;
        
        public Price(int price, int idx){
            this.price = price;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        PriorityQueue<Price> pq = new PriorityQueue<>((a,b) -> b.price - a.price);
        for(int i = 0; i < len; i++){
            while(!pq.isEmpty() && pq.peek().price > prices[i]){
                Price p = pq.poll();
                answer[p.idx] = i - p.idx;
            }
            pq.offer(new Price(prices[i],i));
        }
        while(!pq.isEmpty()){
                Price p = pq.poll();
                answer[p.idx] = len - 1 - p.idx;
            }
        return answer;
    }
}