import java.io.*;
import java.util.*;

public class Main {

    static class Sticker{
        int d;
        int a;

        public Sticker(int d, int a){
            this.d = d;
            this.a = a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Character[] stickers = new Character[m];
        // Map<Character,Sticker> map = new HashMap<>();
        // [REMOVED] 문자→단일 Sticker 매핑은 같은 알파벳의 여러 타입을 덮어써서 오답 원인.

        // [ADDED] 스티커 "종류별" 배열 + 알파벳별 최소 구매비, 전체 최소 구매비
        final int INF = 1_000_000_000;
        char[] typeChar = new char[m + 1]; // 1-based: j번 스티커의 문자
        int[] typeD   = new int[m + 1];    // 1-based: j번 스티커 제거비
        int[] typeA   = new int[m + 1];    // 1-based: j번 스티커 구매비
        int[] minBuy  = new int[26];       // 알파벳별 최소 구매비
        Arrays.fill(minBuy, INF);
        int minBuyAny = INF;               // 아무 글자 1장 살 때 최저가 (빈칸 메움용)

        for(int j = 1; j <= m; j++){
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int d = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            // stickers[i] = ...; map.put(...)
            // [REMOVED] 기존 Map/배열 채우기

            // [ADDED] 타입별로 저장 + 최소 구매비 갱신
            typeChar[j] = c;
            typeD[j] = d;
            typeA[j] = a;
            int idx = c - 'a';
            if (a < minBuy[idx]) minBuy[idx] = a;
            if (a < minBuyAny)   minBuyAny   = a;
        }

        int[] board = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            board[i] = Integer.parseInt(st.nextToken());
        }

        String s = br.readLine();

        // for(int i = 0; i < s.length(); i++){
        //     if(!map.containsKey(s.charAt(i))){
        //         System.out.println(-1);
        //         return;
        //     }
        // }
        // [CHANGED] S에 필요한 문자가 아예 없으면 불가능 → minBuy로 판정
        for (int i = 0; i < s.length(); i++) {
            if (minBuy[s.charAt(i) - 'a'] == INF) {
                System.out.println(-1);
                return;
            }
        }

        // String cur = "";
        // for(int i = 0; i < n; i++){
        //     cur += stickers[board[i]-1];
        // }
        // [CHANGED] 보드 전개: 종류→문자/제거비 배열로 펼친 뒤 StringBuilder로 현재 문자열 생성
        char[] boardChar = new char[n];   // [ADDED]
        int[]  boardRemove = new int[n];  // [ADDED]
        for (int i = 0; i < n; i++) {
            int t = board[i];
            boardChar[i] = typeChar[t];
            boardRemove[i] = typeD[t];
        }
        StringBuilder curSB = new StringBuilder(n); // [ADDED]
        for (int i = 0; i < n; i++) curSB.append(boardChar[i]);
        String cur = curSB.toString();

        if(cur.contains(s)){
            System.out.println(0);
            return;
        }

        // int answer = Integer.MAX_VALUE;
        // for(int i = 0; i <= n-k; i++){
        //     String temp = cur.substring(i,i+k);
        //     int sum = 0;
        //     for(int j = 0; j < k; j++){
        //         int num = map.get(temp.charAt(j)).d + map.get(s.charAt(j)).a;
        //         if(temp.charAt(j) == s.charAt(j)){
        //             num = 0;
        //         }
        //         sum += num;
        //     }
        //     if(sum < answer){
        //         answer = sum;
        //     }
        // }
        // System.out.println(answer);
        // [REMOVED] 단순히 각 칸마다 d+a 계산 → 재활용/스왑/밖에서 떼오기/빈칸 메우기 미고려로 오답.

        // [ADDED] 창마다 수요/공급 기반 최소비용 계산:
        //  1) 창 안 불일치 칸 제거비 합산 + 떼낸 스티커는 재활용 pool로.
        //  2) 남은 수요는
        //     - 창 밖에서 같은 글자 떼오기(그 칸 제거비 r) + (빈칸 메움: 무료(pool) 또는 유료(minBuyAny))
        //     - 그 글자 새로 사기(minBuy[c])
        //     를 개수마다 더 싼 쪽으로 선택.
        //  3) 무료 메움(= pool 사용)이 가능한 개수만큼 절감치를 큰 것부터 적용.

        long answer = INF;

        for (int start = 0; start <= n - k; start++) {
            int[] need = new int[26];   // 창에서 S 만들기 위해 필요한 각 글자 수
            int[] poolIn = new int[26]; // 창 안에서 떼낸(잘못된) 글자 공급
            long costRemoveIn = 0;      // 창 안 제거 총비용

            // [ADDED] 창 내부 처리
            for (int j = 0; j < k; j++) {
                char curC = boardChar[start + j];
                char want = s.charAt(j);
                if (curC != want) {
                    poolIn[curC - 'a']++;
                    need[want - 'a']++;
                    costRemoveIn += boardRemove[start + j];
                }
            }

            // [ADDED] 창 밖에서 같은 글자를 떼올 때 제거비 목록 (싼 순)
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] outsideCosts = new ArrayList[26];
            for (int c = 0; c < 26; c++) outsideCosts[c] = new ArrayList<>();
            for (int pos = 0; pos < n; pos++) {
                if (pos < start || pos >= start + k) {
                    outsideCosts[boardChar[pos] - 'a'].add(boardRemove[pos]);
                }
            }
            for (int c = 0; c < 26; c++) Collections.sort(outsideCosts[c]);

            // [ADDED] 1차: 같은 글자는 창 안에서 떼낸 것으로 무료 충당
            for (int c = 0; c < 26; c++) {
                int use = Math.min(need[c], poolIn[c]);
                need[c] -= use;
                poolIn[c] -= use;
            }

            // [ADDED] 무료 메움(pool) 가능한 잔여량
            int leftover = 0;
            for (int c = 0; c < 26; c++) leftover += poolIn[c];

            // [ADDED] 기본 비용과 "무료 메움 전환 시 절감액" 모음
            long baseCost = 0;
            ArrayList<Integer> improvements = new ArrayList<>();

            for (int c = 0; c < 26; c++) {
                int req = need[c];
                if (req == 0) continue;

                List<Integer> outs = outsideCosts[c];
                int takeable = Math.min(req, outs.size());
                int buyC = minBuy[c];

                // 밖에서 못 채우는 몫은 전부 구매
                int mustBuy = req - takeable;
                if (mustBuy > 0) baseCost += 1L * mustBuy * buyC;

                // 밖에서 가능한 개수에 대해, 기본은 "유료 메움(r + minBuyAny)"과 "그 글자 구매(buyC)" 중 싼 쪽 선택
                // 이후 leftover(무료 메움 가능 개수)만큼 절감치(=무료로 바꿨을 때 이득)를 큰 것부터 적용
                for (int t = 0; t < takeable; t++) {
                    int r = outs.get(t);
                    int costPullPaid = (minBuyAny >= INF ? INF : r + minBuyAny); // 유료 메움
                    int basePick = Math.min(buyC, costPullPaid);

                    baseCost += basePick;

                    // 무료 메움이 가능하면, 무료로 바꿨을 때 절감되는 양을 저장
                    // - 기존이 구매였다면: 절감 = buyC - r
                    // - 기존이 유료 메움이었다면: 절감 = (r + minBuyAny) - r = minBuyAny
                    if (leftover > 0) {
                        if (buyC <= costPullPaid) {
                            // 기본 선택: 구매 → 무료 메움 전환 시 절감
                            if (buyC > r) {
                                improvements.add(buyC - r);
                            }
                        } else {
                            // 기본 선택: 유료 메움 → 무료 메움 전환 시 절감
                            if (minBuyAny < INF) {
                                improvements.add(minBuyAny);
                            }
                        }
                    }
                }
            }

            // [ADDED] 무료 메움 가능 개수만큼, 절감 큰 것부터 적용
            improvements.sort(Collections.reverseOrder());
            long extraSave = 0;
            for (int i = 0; i < Math.min(leftover, improvements.size()); i++) {
                extraSave += improvements.get(i);
            }

            long total = costRemoveIn + baseCost - extraSave;
            if (total < answer) answer = total;
        }

        System.out.println(answer >= INF ? -1 : answer);
    }
}
