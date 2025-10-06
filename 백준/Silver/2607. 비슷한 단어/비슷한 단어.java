import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] baseCount = new int[26];
        for(char c : s.toCharArray()){
            baseCount[c-'A']++;
        }
        int similar = 0;
        for(int i = 1; i < n; i++){
            String word = br.readLine();
            int[] wordCount = new int[26];
            for(char c : word.toCharArray()){
                wordCount[c-'A']++;
            }
            int diff = 0;
            for(int j = 0; j < 26; j++){
                diff += Math.abs(baseCount[j] - wordCount[j]);
            }
            
            int lenDiff = Math.abs(s.length() - word.length());
            
            // 같은 구성
            if(diff == 0){
                similar++;
            }
            // 한 문자 추가/제거
            else if(diff == 1 && lenDiff == 1){
                similar++;
            }
            // 한 문자 바꾸기
            else if(diff == 2 && lenDiff == 0){
                similar++;
            }
        }
        System.out.println(similar);
    }
}