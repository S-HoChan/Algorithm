package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q15653 {   // 구슬 탈출 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int blueY = -1, blueX = -1;
        int redY = -1, redX = -1;
        boolean[][][][] visited = new boolean[n][m][n][m];   // BLUE(y, x), RED(y, x)
        LinkedList<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'B') {
                    blueY = i;
                    blueX = j;
                    map[i][j] = '.';
                    queue.add(new Node(i, j, 0, 'B'));
                } else if (map[i][j] == 'R') {
                    redY = i;
                    redX = j;
                    map[i][j] = '.';
                    queue.add(new Node(i, j, 0, 'R'));
                }
            }
        }
        visited[blueY][blueX][redY][redX] = true;

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Node blue = queue.poll();
            Node red = queue.poll();
            if (blue.color == 'R') {
                Node temp = red;
                red = blue;
                blue = temp;
            }

            for (int i = 0; i < 4; i++) {
                boolean blueCheck = false, redCheck = false;
                boolean redFirst = false;
                int by = blue.y, bx = blue.x;
                int ry = red.y, rx = red.x;

                int bny = by, bnx = bx;
                while (true) {    // blue move
                    bny += dy[i];
                    bnx += dx[i];
                    if (bny == ry && bnx == rx) redFirst = true;
                    if (map[bny][bnx] == '#') break;
                    if (map[bny][bnx] == 'O') {
                        blueCheck = true;
                        break;
                    }
                    by = bny;
                    bx = bnx;
                }

                int rny = ry, rnx = rx;
                while (true) {  // red move
                    rny += dy[i];
                    rnx += dx[i];
                    if (map[rny][rnx] == '#') break;
                    if (map[rny][rnx] == 'O') {
                        redCheck = true;
                        break;
                    }
                    ry = rny;
                    rx = rnx;
                }

                if (blueCheck) continue;
                if (redCheck) {
                    System.out.println(red.cnt + 1);
                    return;
                }

                if (by == ry && bx == rx) {
                    if (redFirst) {
                        by -= dy[i];
                        bx -= dx[i];
                    } else {
                        ry -= dy[i];
                        rx -= dx[i];
                    }
                }

                if (!visited[by][bx][ry][rx]) {
                    visited[by][bx][ry][rx] = true;
                    queue.add(new Node(by, bx, blue.cnt + 1, 'B'));
                    queue.add(new Node(ry, rx, red.cnt + 1, 'R'));
                }
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int y, x, cnt;
        char color;

        Node(int y, int x, int cnt, char c) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.color = c;
        }
    }
}
