import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for(int size : course){
            Map<String,Integer> map = new HashMap<>();
            for(String order : orders){
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                func(chars, size, 0, new StringBuilder(), map);
            }
            if(map.isEmpty()) continue;
            int max = Collections.max(map.values());
            if (max >= 2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == max) {
                        result.add(entry.getKey());
                    }
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    public void func(char[] chars, int size, int start, StringBuilder sb, Map<String,Integer> map){
        if(sb.length() == size){
            map.merge(sb.toString(), 1, Integer::sum);
            return;
        }
        for(int i = start; i < chars.length; i++){
            sb.append(chars[i]);
            func(chars, size, i + 1, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}