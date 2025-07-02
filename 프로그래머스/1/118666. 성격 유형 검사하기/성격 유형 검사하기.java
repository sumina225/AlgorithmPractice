import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> mbtiScores = new HashMap<>();
        
        // 초기 점수 설정
        mbtiScores.put('R', 0);
        mbtiScores.put('T', 0);
        mbtiScores.put('C', 0);
        mbtiScores.put('F', 0);
        mbtiScores.put('J', 0);
        mbtiScores.put('M', 0);
        mbtiScores.put('A', 0);
        mbtiScores.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int choice = choices[i];

            char type1 = s.charAt(0); 
            char type2 = s.charAt(1);

            if (choice < 4) {
                mbtiScores.put(type1, mbtiScores.get(type1) + (4 - choice));
            } else if (choice > 4) {
                mbtiScores.put(type2, mbtiScores.get(type2) + (choice - 4));
            }
            
        }

        // 결과 계산 및 조합
        sb.append(mbtiScores.get('R') >= mbtiScores.get('T') ? 'R' : 'T');
        sb.append(mbtiScores.get('C') >= mbtiScores.get('F') ? 'C' : 'F');
        sb.append(mbtiScores.get('J') >= mbtiScores.get('M') ? 'J' : 'M');
        sb.append(mbtiScores.get('A') >= mbtiScores.get('N') ? 'A' : 'N');

        return sb.toString();
    }
}