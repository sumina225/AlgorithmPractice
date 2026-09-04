import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int num = 2;
        while(num <= n) {
            list.add((list.get(num-1) + list.get(num-2)) % 1234567);
            num++;
        }
        return list.get(n);
    }
}