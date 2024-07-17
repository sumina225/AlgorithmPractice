import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[][] nums = new int[n][3];	//
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = i;
		}
		Arrays.sort(nums, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int count = 0;
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			if(i < n-1 && (nums[i][0] ==nums[i+1][0])) {
				result[nums[i][1]] = count;
			}
			else {
				result[nums[i][1]] = count;
				count++;
			}
		}
		for(int i = 0; i < n; i++) {
			bw.write(result[i] + " ");
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
