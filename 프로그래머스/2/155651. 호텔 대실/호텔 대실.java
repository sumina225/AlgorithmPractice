import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] nums = new int[60*24];
        for(int i = 0; i < book_time.length; i++){
            String[] s1 = book_time[i][0].split(":");
            String[] s2 = book_time[i][1].split(":");
            int time1 = Integer.parseInt(s1[0])*60 + Integer.parseInt(s1[1]);
            int time2 = Integer.parseInt(s2[0])*60 + Integer.parseInt(s2[1]) + 10;
            if(time2 >= 1440) time2 = 60*24-1;
            for(int j = time1; j < time2; j++){
                nums[j]++;
            }
        }
        Arrays.sort(nums);
        return nums[60*24-1];
    }
}