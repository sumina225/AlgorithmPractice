import java.io.*;
import java.util.*;

public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			int[][] nums = new int[n][2];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				nums[i][0] = Integer.parseInt(st.nextToken());
				nums[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums,new Comparator<int[]>() {
				@Override
				public int compare(int[] a1, int[] a2) {
					if(a1[1] == a2[1]) {
						return a1[0] - a2[1];
					}
					return a1[1] - a2[1];
				}
			});
			int result = 1;
			int time = nums[0][1];
			for(int i = 1; i < n; i++) {
				if(nums[i][0] >= time) {
					time = nums[i][1];
					result++;
				}
			}
			bw.write(result + "");
			
			br.close();
			bw.flush();
			bw.close();
		}
}

