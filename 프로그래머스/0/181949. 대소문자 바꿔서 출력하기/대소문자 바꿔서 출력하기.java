import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            if(str[i] >= 'a' && str[i] <= 'z'){
                str[i] = (char)(str[i] - 'a' + 'A');
            }else{
                str[i] = (char)(str[i] - 'A' + 'a');
            }
        }
        System.out.println(str);
    }
}