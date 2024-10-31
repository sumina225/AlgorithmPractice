import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] nums = new int[1001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[Integer.parseInt(st.nextToken())] = 1;
		}
		int count = 0;
		for(int i = 0; i < 1001; i++) {
			if(nums[i] == 1) {
				count++;
				i += l-1;
			}
		}
		System.out.println(count);
	}
}