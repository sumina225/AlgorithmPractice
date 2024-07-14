import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int num = 0;
		int count = 1;
		boolean type = true;
		while(true) {
			if(x <= num + count) {
				if(!type) {
					System.out.println((x-num) + "/" + (count+1-(x-num)));
				}
				else {
					System.out.println((count+1-(x-num)) + "/" + (x-num));
				}
				break;
			}
			num += count;
			count++;
			type = !type;
		}
		
	}
}
