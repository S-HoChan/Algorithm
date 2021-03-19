package ProgrammersLevel3;

import java.util.ArrayList;
import java.util.Collections;

public class MatchingCard {
    int nowY;
    int nowX;

    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        ArrayList<Card> list = new ArrayList<>();
        nowY = r;
        nowX = c;   // 커서 위치

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    answer++;
                    list.add(new Card(i, j, board[i][j]));
                }
            }
        }   // enter count

        while (!list.isEmpty()) {
            Collections.sort(list); // todo. 순열로 모든 경우의 수 계산하기
            Card now = list.get(0);
            list.remove(0);

            Card second = new Card(0, 0, 0);
            for (int i = 0; i < list.size(); i++) {
                if (now.type == list.get(i).type) {
                    second = list.get(i);
                    list.remove(i);
                    break;
                }
            }

            answer += moveCnt(now, nowY, nowX); // first card move
            nowY = now.y;
            nowX = now.x;
            answer += moveCnt(second, nowY, nowX);  // second card move
            nowY = second.y;
            nowX = second.x;
        }

        return answer;
    }

    public int moveCnt(Card card, int r, int c) {
        int ans = 0;
        if (card.y != r) {
            if (card.y == 0 || card.y == 3) ans++;
            else ans += Math.abs(card.y - r);
        }
        if (card.x != c) {
            if (card.x == 0 || card.x == 3) ans++;
            else ans += Math.abs(card.x - r);
        }
        return ans;
    }

    public class Card implements Comparable<Card> {
        int y;
        int x;
        int type;

        Card(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(Card o) {
            return moveCnt(this, nowY, nowX) - moveCnt(o, nowY, nowX);
        }
    }
}
