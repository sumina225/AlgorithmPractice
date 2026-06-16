import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        String[] cut = new String[privacies.length];
        for(int i = 0; i < cut.length; i++){
            String[] privacy = privacies[i].split(" ");
            String termNum = "";
            for(int j = 0; j < terms.length; j++){
                String[] term = terms[j].split(" ");
                if(term[0].equals(privacy[1])){
                    termNum = term[1];
                }
            }
            String[] date = privacy[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            day--;
            if(day == 0){
                day = 28;
                month--;
            }
            month += Integer.parseInt(termNum);
            year += ((month - 1) / 12);
            month = ((month - 1) % 12) + 1;
            StringBuilder sb = new StringBuilder();
            sb.append(year).append(".");
            if(month < 10){
                sb.append("0");
            }
            sb.append(month).append(".");
            if(day < 10){
                sb.append("0");
            }
            sb.append(day);
            cut[i] = sb.toString();
        }
        String[] todayDate = today.split("\\.");
        for(int i = 0; i < cut.length; i++){
            String[] cutDate = cut[i].split("\\.");
            if(Integer.parseInt(todayDate[0]) > Integer.parseInt(cutDate[0])){
                list.add(i+1);
            }else if(Integer.parseInt(todayDate[0]) == Integer.parseInt(cutDate[0]) && Integer.parseInt(todayDate[1]) > Integer.parseInt(cutDate[1])){
                list.add(i+1);
            }else if(Integer.parseInt(todayDate[0]) == Integer.parseInt(cutDate[0]) && Integer.parseInt(todayDate[1]) == Integer.parseInt(cutDate[1]) && Integer.parseInt(todayDate[2]) > Integer.parseInt(cutDate[2])){
                list.add(i+1);
            }
        }
        return list;
    }
}