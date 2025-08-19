import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String,String> map = new HashMap<>();
        Map<String,Integer> money = new HashMap<>();
        for(int i = 0; i < referral.length; i++){
            money.put(enroll[i],0);
            map.put(enroll[i],referral[i]);
        }
        for(int i = 0; i < seller.length; i++){
            int num = amount[i]*100;
            String cur = seller[i];
            while(map.containsKey(cur)){
                int p = num / 10;
                num -= p;
                money.replace(cur, money.get(cur) + num);
                num = p;
                cur = map.get(cur);
                if(num == 0) break;
            }
        }
        for(int i = 0; i < answer.length; i++){
            answer[i] = money.get(enroll[i]);
        }
        return answer;
    }
}