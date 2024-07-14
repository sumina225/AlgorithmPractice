import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[3];
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}
		if(sum != 180) {
			System.out.println("Error");
			return;
		}
		int cmax = 0;
		for(int i = 0; i < 3; i++) {
			int count = 0;
			for(int j = 0; j < 3; j++) {
				if(nums[i] == nums[j]) count++;
			}
			if(count > cmax) {
				cmax = count;
			}
		}
		if(cmax == 1) {
			System.out.println("Scalene");
		}
		else if(cmax == 2) {
			System.out.println("Isosceles");
		}
		else {
			System.out.println("Equilateral");
		}
	}
}
