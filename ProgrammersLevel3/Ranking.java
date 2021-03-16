package ProgrammersLevel3;

import java.util.ArrayList;
import java.util.HashSet;

public class Ranking {
    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i <= n; i++) {  // 0번은 사용 안함
            players.add(new Player(i));
        }

        for (int[] result : results) {
            players.get(result[0]).win.add(result[1]);  // 이긴 기록 추가
            players.get(result[1]).lose.add(result[0]); // 진 기록 추가
        }

        for (int depth = 0; depth < n; depth++) {
            for (int i = 1; i <= n; i++) {
                Player player = players.get(i);
                HashSet<Integer> winSet = new HashSet<>();

                for (Integer win : player.win) {
                    for (Integer w : players.get(win).win) {
                        winSet.add(w);
                    }
                }
                player.win.addAll(winSet);

                HashSet<Integer> loseSet = new HashSet<>();

                for (Integer lose : player.lose) {
                    for (Integer l : players.get(lose).lose) {
                        loseSet.add(l);
                    }
                }
                player.lose.addAll(loseSet);
            }
        }

        for (Player player : players) {
            if (player.win.size() + player.lose.size() == n - 1) answer++;
        }

        return answer;
    }

    class Player {
        int code;

        HashSet<Integer> win = new HashSet<>();
        HashSet<Integer> lose = new HashSet<>();

        public Player(int code) {
            this.code = code;
        }
    }
}
