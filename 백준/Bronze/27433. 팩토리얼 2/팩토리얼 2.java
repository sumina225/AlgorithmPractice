import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long result = 1;
		for(int i = n; i >= 1; i--) {
			result *= i;
		}
		System.out.println(result);
	}
}
