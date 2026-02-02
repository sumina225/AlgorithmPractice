import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int num = n;
        int now = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        while(num > 0){
            now = (now+k) % num;
            if(num == 1){
                sb.append(list.get(now));
                break;
            }
            sb.append(list.get(now)).append(", ");
            list.remove(now);
            now--;
            num--;
        }
        sb.append(">");
        System.out.println(sb.toString());

    }
}
