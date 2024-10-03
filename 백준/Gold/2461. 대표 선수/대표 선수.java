import java.io.*;
import java.util.*;


public class Main {
	
	static class Player{
		int score;
		int teamNum;
		public Player(int score, int teamNum) {
			super();
			this.score = score;
			this.teamNum = teamNum;
		}
		
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] nums = new int[n][m];
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m; j++) {
        		nums[i][j] = Integer.parseInt(st.nextToken());
        		players.add(new Player(nums[i][j],i));
        	}
        	Arrays.sort(nums[i]);
        }
        
        Collections.sort(players, new Comparator<Player>() {
        	@Override
        	public int compare(Player a, Player b) {
        		return a.score - b.score;
        	}
        });
        int start = 0;
        int end = 0;
        int[] count = new int[n];
        int teamSelected = 0;
        int min = Integer.MAX_VALUE;
        while(end < players.size()) {
        	if(count[players.get(end).teamNum] == 0) {
        		teamSelected++;
        	}
        	count[players.get(end).teamNum]++;
        	end++;
        	while(teamSelected == n) {
        		int curDiff = players.get(end-1).score - players.get(start).score;
        		min = Math.min(curDiff, min);
        		
        		count[players.get(start).teamNum]--;
        		if(count[players.get(start).teamNum] == 0) {
        			teamSelected--;
        		}
        		start++;
        	}
        }
        
        System.out.println(min);

    }

}
