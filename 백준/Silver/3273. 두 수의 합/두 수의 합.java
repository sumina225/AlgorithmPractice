import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(br.readLine());
		Arrays.sort(nums);
		int start = 0;
		int end = n-1;
		int count = 0;
		while(start < end) {
			if(nums[start] + nums[end] == target) {
				count++;
				start++;
				end--;
			}else if(nums[start] + nums[end] < target) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(count);

	}
}