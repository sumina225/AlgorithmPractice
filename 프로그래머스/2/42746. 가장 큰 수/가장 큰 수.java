import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] sNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            sNumbers[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(sNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        if(sNumbers[0].equals("0")){
            return "0";
        }
        for(int i = 0; i < numbers.length; i++){
            answer += sNumbers[i];
        }
        return answer;

    }
}