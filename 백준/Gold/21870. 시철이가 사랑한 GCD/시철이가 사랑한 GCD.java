import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] nums;
	
	public static long sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(cut(0,n-1));
		
	}
	
	public static int cut(int start, int end) {
		if(start == end) {
			return nums[start];
		}
		int mid = (end-start+1)/2;
		// 왼쪽
		int leftSum = 0;
		int index = start;
		int c = nums[start];
		while(index <= start+mid-1) {
			c = gcd(c,nums[index++]);
		}
		leftSum = c + cut(start+mid,end);
		
		// 오른쪽
		int rightSum = 0;
		c = nums[end];
		while(index <= end) {
			c = gcd(c,nums[index++]);
		}
		rightSum = c+ cut(start,start+mid-1);
		
		return Math.max(leftSum, rightSum);
		
		
		
	}
	// 유클리드 호제법
	public static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b,a%b);
	}
	
}