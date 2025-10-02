import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        Set<Integer> ham = new HashSet<>();
        Set<Integer> peo = new HashSet<>();
        int answer = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == 'H'){
                boolean eat = false;
                for(int j = k; j >= 1; j--){
                    if(i-j >= 0){
                        if(peo.contains(i-j)){
                            answer++;
                            peo.remove(i-j);
                            eat = true;
                            break;
                        }
                    }
                }
                if(!eat){
                    ham.add(i);
                }
            }else{
                boolean eat = false;
                for(int j = k; j >= 1; j--){
                    if(i-j >= 0){
                        if(ham.contains(i-j)){
                            answer++;
                            ham.remove(i-j);
                            eat = true;
                            break;
                        }
                    }
                }
                if(!eat){
                    peo.add(i);
                }
            }
        }
        System.out.println(answer);
    }
}
