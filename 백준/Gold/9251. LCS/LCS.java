import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫 번째 문자열 입력
		String s1 = br.readLine();
		// 두 번째 문자열 입력
		String s2 = br.readLine();
		
		// DP 테이블 초기화 (s1과 s2의 길이에 각각 +1 크기를 가진 2차원 배열 생성)
		// dp[i][j]는 s1의 첫 i개의 문자와 s2의 첫 j개의 문자 사이의 LCS 길이를 의미
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		
		// DP 테이블 채우기
		for (int i = 1; i <= s1.length(); i++) { // 첫 번째 문자열 s1의 문자들에 대해 반복
			for (int j = 1; j <= s2.length(); j++) { // 두 번째 문자열 s2의 문자들에 대해 반복
				// s1의 i-1번째 문자와 s2의 j-1번째 문자가 같다면
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					// 대각선 왼쪽 위(dp[i-1][j-1]) 값에 1을 더한 값을 dp[i][j]에 저장
					// (문자가 같으므로 LCS에 길이 1이 추가됨)
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					// 문자가 다르면, 위(dp[i-1][j])와 왼쪽(dp[i][j-1]) 값 중 더 큰 값을 dp[i][j]에 저장
					// (LCS 길이가 유지되므로 이전 최댓값을 가져옴)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		// 최종적으로 dp[s1.length()][s2.length()]에 저장된 값이 LCS의 길이
		System.out.println(dp[s1.length()][s2.length()]);
	}
}
