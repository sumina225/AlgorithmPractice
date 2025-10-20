import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Set<Integer> broken = new HashSet<>();
        Set<Integer> remain = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < s; i++){
            broken.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < r; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(broken.contains(temp)){
                broken.remove(temp);
                continue;
            }
            remain.add(temp);
        }
        int answer = broken.size();

        for(int num : broken){
            if(remain.contains(num-1)){
                remain.remove(num-1);
                answer--;
            }else if(remain.contains(num+1)){
                remain.remove(num+1);
                answer--;
            }
        }
        System.out.println(answer);
    }
}