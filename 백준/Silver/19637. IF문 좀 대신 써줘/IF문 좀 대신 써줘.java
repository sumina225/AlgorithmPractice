import java.io.*;
import java.util.*;

public class Main {

    static class Name{
        String name;
        int max;

        public Name(String name, int max){
            this.name = name;
            this.max = max;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Name> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String sTemp = st.nextToken();
            int nTemp = Integer.parseInt(st.nextToken());
            if(list.isEmpty()){
                list.add(new Name(sTemp,nTemp));
            }else if(!list.isEmpty() && list.get(list.size()-1).max != nTemp){
                list.add(new Name(sTemp,nTemp));
            }

        }
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(br.readLine());
            int first = 0;
            int last = list.size()-1;
            int result = 0;
            while(first <= last){
                int mid = (first+last)/2;
                if(num <= list.get(mid).max){
                    result = mid;
                    last = mid-1;
                }else{
                    first = mid + 1;
                }
            }
            sb.append(list.get(result).name).append("\n");
        }
        System.out.println(sb.toString());

    }
}
