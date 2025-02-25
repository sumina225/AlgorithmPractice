import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int start = 0;
        int end = n-1;
        int result1 = start;
        int result2 = end;
        int result = Math.abs(list.get(start) + list.get(end));
        while(start < end){
            if(Math.abs(list.get(start) + list.get(end)) >= result){
                if(Math.abs(list.get(start)) >= Math.abs(list.get(end))){
                    start++;
                }else{
                    end--;
                }
            }else{
                result = Math.abs(list.get(start) + list.get(end));
                result1 = start;
                result2 = end;
            }
        }
        System.out.println(list.get(result1) + " " + list.get(result2));
    }
}