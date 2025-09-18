import java.util.*;

class Solution {

    // 광물 5개 단위로 묶은 그룹 클래스
    static class Group {
        int dia;   // 다이아 개수
        int iron;  // 철 개수
        int stone; // 돌 개수

        public Group(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int totalPickCount = picks[0] + picks[1] + picks[2]; // 총 곡괭이 수
        int maxMineCount = totalPickCount * 5;               // 최대 캘 수 있는 광물 수
        int n = Math.min(minerals.length, maxMineCount);     // 실제 캘 광물 수

        // 5개 단위 그룹 만들기
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < n; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < n; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) dia++;
                else if (m.equals("iron")) iron++;
                else stone++;
            }
            groups.add(new Group(dia, iron, stone));
        }

        // Comparator로 그룹 정렬 (난이도 높은 순서: 다이아 > 철 > 돌)
        Collections.sort(groups, new Comparator<Group>() {
            @Override
            public int compare(Group g1, Group g2) {
                if (g1.dia != g2.dia) return g2.dia - g1.dia;
                if (g1.iron != g2.iron) return g2.iron - g1.iron;
                return g2.stone - g1.stone;
            }
        });

        int fatigue = 0;

        // 정렬된 그룹 순서대로 곡괭이 배정
        for (Group g : groups) {
            if (picks[0] > 0) { // 다이아 곡괭이
                fatigue += g.dia * 1 + g.iron * 1 + g.stone * 1;
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이
                fatigue += g.dia * 5 + g.iron * 1 + g.stone * 1;
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이
                fatigue += g.dia * 25 + g.iron * 5 + g.stone * 1;
                picks[2]--;
            } else {
                break; // 더 이상 곡괭이 없음
            }
        }

        return fatigue;
    }
}
