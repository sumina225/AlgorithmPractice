import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int start = 1;
        int j = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < j; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > end){
                answer += num-end;
                start += num-end;
                end += num-end;
            }else if(num < start){
                answer += start-num;
                end -= start-num;
                start -= start-num;
            }
        }
        System.out.println(answer);
    }
}
