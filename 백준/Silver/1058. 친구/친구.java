import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        int maxFriends = 0;
        for (int i = 0; i < n; i++) {
            int directFriends = 0;
            boolean[] isFriend = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'Y') {
                    directFriends++;
                    isFriend[j] = true; 
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'Y') {
                    for (int k = 0; k < n; k++) {
                        if (matrix[j][k] == 'Y' && k != i && !isFriend[k]) {
                            isFriend[k] = true; 
                        }
                    }
                }
            }
            int totalFriends = 0;
            for (int k = 0; k < n; k++) {
                if (isFriend[k]) {
                    totalFriends++;
                }
            }
            maxFriends = Math.max(maxFriends, totalFriends);
        }
        System.out.println(maxFriends);
    }
}
