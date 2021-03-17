package ProgrammersLevel2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dy[i];
                int x = now.x + dx[i];
                if (y < 0 || x < 0 || y >= maps.length || x >= maps[0].length) continue;
                if (maps[y][x] == 0) continue;

                if (y == maps.length - 1 && x == maps[0].length - 1) {
                    return now.cnt + 1;
                } else {
                    queue.add(new Point(y, x, now.cnt + 1));
                }
                maps[y][x] = 0;
            }
        }

        return -1;
    }

    public class Point {
        int y;
        int x;
        int cnt;

        Point(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.cnt = c;
        }
    }
}
