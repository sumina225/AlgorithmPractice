import java.io.*;
import java.util.*;

public class Main {

    static class Country{
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze){
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] nums = new int[n][4];
        Country[] countries = new Country[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
            countries[i] = new Country(nums[i][0],nums[i][1],nums[i][2],nums[i][3]);
        }

        // k번 국가의 메달 정보 찾기
        Country target = null;
        for(int i = 0; i < n; i++){
            if(countries[i].num == k){
                target = countries[i];
                break;
            }
        }

        // k번 국가보다 성적이 좋은 국가 개수 세기
        int rank = 1;
        for(int i = 0; i < n; i++){
            // 금메달이 더 많으면 순위가 높음
            if(countries[i].gold > target.gold){
                rank++;
            }
            // 금메달이 같고 은메달이 더 많으면 순위가 높음
            else if(countries[i].gold == target.gold && countries[i].silver > target.silver){
                rank++;
            }
            // 금,은메달이 같고 동메달이 더 많으면 순위가 높음
            else if(countries[i].gold == target.gold && countries[i].silver == target.silver && countries[i].bronze > target.bronze){
                rank++;
            }
        }

        System.out.println(rank);
    }
}