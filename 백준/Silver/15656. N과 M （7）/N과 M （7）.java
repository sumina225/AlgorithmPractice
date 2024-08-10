import java.io.*;
import java.util.*;

public class Main {
	public static int[] nums;
	public static StringBuilder sb;
	public static int[] arr;
	public static int m;
	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		func(0);
		System.out.println(sb.toString());
		
	}
	
	public static void func(int k) {
		if(k == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < n; i++) {
			arr[k] = nums[i];
			func(k+1);
		}
	}
}