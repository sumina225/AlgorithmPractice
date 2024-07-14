import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] nums = new int[9][9];
		int max = 0;
		int[] point = new int[2];
		for(int i = 0; i < 9; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			for(int j = 0; j < 9; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				if(nums[i][j] > max) {
					max = nums[i][j];
					point[0] = i;
					point[1] = j;
				}
			}
		}
		System.out.println(max);
		System.out.println((point[0]+1) + " " + (point[1]+1));
		
		
	}
}

