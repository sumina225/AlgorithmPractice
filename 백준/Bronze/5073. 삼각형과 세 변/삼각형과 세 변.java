import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input;
		while(true) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int[] nums = new int[3];
			int maxlen = 0;
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				if(nums[i] > maxlen) maxlen = nums[i]; 
				sum += nums[i];
			}
			if(sum == 0) break;
			if(2*maxlen >= sum) {
				System.out.println("Invalid");
				continue;
			}
			int max = 0;
			for(int i = 0; i < 3; i++) {
				int count = 0;
				for(int j = 0; j < 3; j++) {
					if(nums[i] == nums[j]) count++;
				}
				if(max < count) max = count;
			}
			if(max == 1) {
				System.out.println("Scalene");
			}
			else if(max == 2) {
				System.out.println("Isosceles");
			}
			else {
				System.out.println("Equilateral");
			}
		}
	}
}
