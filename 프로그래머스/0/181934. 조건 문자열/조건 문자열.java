class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        boolean ans = false;
        if(ineq.equals("<")){
            if(eq.equals("=")){
                ans = n <= m;
            }else{
                ans = n < m;
            }
        }else{
            if(eq.equals("=")){
                ans = n >= m;
            }else{
                ans = n > m;
            }
        }
        if(ans){
            answer = 1;
        }
        return answer;
    }
}