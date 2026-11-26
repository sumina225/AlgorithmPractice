import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(arr.length > 1){
            Arrays.sort(arr);
            ans += arr[0] * arr[arr.length - 1];
            arr[0] = arr[0] + arr[arr.length - 1];
            arr = Arrays.copyOfRange(arr, 0, arr.length - 1);
        }
        System.out.println(ans);
    }
}