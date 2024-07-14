import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = br.readLine();
		st = new StringTokenizer(input);
		int[] nums = new int[3];
		int max = 0;
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(max < nums[i]) {
				max = nums[i];
			}
			sum += nums[i];
		}
		if(max >= sum-max) {
			sum = sum-(max-(sum-max)) - 1;
		}
		System.out.println(sum);
		
	}
}
