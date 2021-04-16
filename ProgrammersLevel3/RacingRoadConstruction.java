package ProgrammersLevel3;

import java.util.LinkedList;
import java.util.Queue;

public class RacingRoadConstruction {
    public class Route {
        int y;
        int x;
        int cost;
        int direct; // 'U', 'R', 'L', 'D'

        Route(int y, int x, int cost, int direct) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direct = direct;
        }
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0}; // DRUL -> 0123
    int[][] map;
    int answer;
    int n;

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        map = board;
        n = board.length;

        bfs(0, 0, 0, -1);  // -1 : init

        return answer;
    }

    public void bfs(int y, int x, int cost, int dir) {
        Queue<Route> queue = new LinkedList<>();
        queue.add(new Route(y, x, cost, dir));
        map[y][x] = 1;  // visited

        while (!queue.isEmpty()) {
            Route now = queue.poll();
            if (now.x == n - 1 && now.y == n - 1) {
                answer = Math.min(answer, now.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int yp = now.y + dy[i];
                int xp = now.x + dx[i];
                if (yp < 0 || xp < 0 || yp >= n || xp >= n || map[yp][xp] == 1) continue;

                int newCost = now.cost;
                if (now.direct == i || now.direct == -1) newCost += 100;
                else newCost += 600;
                if (map[yp][xp] == 0 || map[yp][xp] >= newCost) {
                    map[yp][xp] = newCost;
                    queue.add(new Route(yp, xp, newCost, i));
                }
            }
        }
    }
}
