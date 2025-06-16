import java.util.*;

class Solution {
    
    static class Price{
        int price;
        int count;
        
        Price(int price, int count){
            this.price = price;
            this.count = count;
        }
    }
    
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Price> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            if(!stack.isEmpty() && stack.peek().price > prices[i]){
                while(!stack.isEmpty() && stack.peek().price > prices[i]){
                    Price temp = stack.pop();
                    answer[temp.count] = i-temp.count;
                }
                Price price = new Price(prices[i],i);
                stack.push(price);
            }else{
                Price price = new Price(prices[i],i);
                stack.push(price);
            }
        }
        while(!stack.isEmpty()){
            Price temp = stack.pop();
            answer[temp.count] = prices.length-temp.count-1;
        }
        return answer;
    }
}