import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            String[] s = temp.split(" ");
            int[] index = new int[2];
            index[0] = -1;
            index[1] = -1;
            boolean find = false;
            for(int j = 0; j < s.length; j++){
                if(!set.contains(s[j].charAt(0))){
                    set.add(Character.toLowerCase(s[j].charAt(0)));
                    set.add(Character.toUpperCase(s[j].charAt(0)));
                    index[0] = j;
                    index[1] = 0;
                    find = true;
                    break;
                }
            }
            if(!find){
                cute : for(int j = 0; j < s.length; j++){
                    for(int k = 0; k < s[j].length(); k++){
                        if(!set.contains(s[j].charAt(k))){
                            set.add(Character.toLowerCase(s[j].charAt(k)));
                            set.add(Character.toUpperCase(s[j].charAt(k)));
                            index[0] = j;
                            index[1] = k;
                            find = true;
                            break cute;
                        }
                    }
                }
            }
            if(find){
                for(int j = 0; j < s.length; j++){
                    for(int k = 0; k < s[j].length(); k++){
                        if(index[0] == j && index[1] == k){
                            sb.append("[").append(s[j].charAt(k)).append("]");
                        }else{
                            sb.append(s[j].charAt(k));
                        }
                    }
                    sb.append(" ");
                }
            }else{
                sb.append(temp);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
