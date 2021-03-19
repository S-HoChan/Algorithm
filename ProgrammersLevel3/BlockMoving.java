package ProgrammersLevel3;

import java.util.LinkedList;
import java.util.Queue;

public class BlockMoving {
    public int solution(int[][] board) {    // todo. BFS 로직 재설정 ( 실패, 시간초과 발생 )
        boolean[][] row = new boolean[board.length][board.length];  // 가로 방문 체크
        boolean[][] col = new boolean[board.length][board.length];  // 세로 방문 체크
        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(0, 0, 0, 1, 0));
        row[0][0] = true;
        row[0][1] = true;

        while (!queue.isEmpty()) {
            Robot now = queue.poll();
            int ly = now.leftY;
            int lx = now.leftX;
            int ry = now.rightY;
            int rx = now.rightX;
            int cnt = now.cnt;
            System.out.println(ly + ", " + lx + " ; " + ry + ", " + rx + " ; " + cnt);

            // 도착
            if (rx == board.length - 1 && ry == board.length - 1) return cnt;

            // 움직일 수 있는가?
            if (ly == ry) {    // 좌, 우 이동
                if (rx < board.length - 1 && board[ry][rx + 1] == 0 && !row[ry][rx + 1]) {  // 우로 이동
                    queue.add(new Robot(ly, lx + 1, ry, rx + 1, cnt + 1));
                    row[ry][rx + 1] = true;
                } else if (lx > 0 && board[ly][lx - 1] == 0 && !row[ly][lx - 1]) {  // 좌로 이동
                    queue.add(new Robot(ly, lx - 1, ry, ry - 1, cnt + 1));
                    row[ly][lx - 1] = true;
                }
                if (ly > 0 && board[ly - 1][lx] == 0 && board[ry - 1][rx] == 0) {   // 위로 회전
                    queue.add(new Robot(ly, lx, ry - 1, rx - 1, cnt + 1));
                    queue.add(new Robot(ly - 1, lx + 1, ry, rx, cnt + 1));
                    col[ry - 1][rx - 1] = true;
                    col[ly - 1][lx + 1] = true;
                }
                if (ly < board.length - 1 && board[ly + 1][lx] == 0 && board[ry + 1][rx] == 0) {    // 아래로 회전
                    queue.add(new Robot(ly, lx, ry + 1, rx - 1, cnt + 1));
                    queue.add(new Robot(ly + 1, lx + 1, ry, rx, cnt + 1));
                    col[ry + 1][rx - 1] = true;
                    col[ly + 1][lx + 1] = true;
                }
            }
            if (lx == rx) {  // 상, 하 이동
                if (ry < board.length - 1 && board[ry + 1][rx] == 0 && !col[ry + 1][rx]) {   // 하로 이동
                    queue.add(new Robot(ly + 1, lx, ry + 1, rx, cnt + 1));
                    col[ry + 1][rx] = true;
                } else if (ly > 0 && board[ly - 1][lx] == 0 && !col[ly - 1][lx]) {  // 상 이동
                    queue.add(new Robot(ly - 1, lx, ry - 1, rx, cnt + 1));
                    col[ly - 1][lx] = true;
                }
                if (lx > 0 && board[ly][lx - 1] == 0 && board[ry][rx - 1] == 0) {   // 좌로 회전
                    queue.add(new Robot(ly, lx, ry - 1, rx - 1, cnt + 1));
                    queue.add(new Robot(ly + 1, lx - 1, ry, rx, cnt + 1));
                    row[ry - 1][rx - 1] = true;
                    row[ly + 1][lx - 1] = true;
                }
                if (lx < board.length - 1 && board[ly][lx + 1] == 0 && board[ry][rx + 1] == 0) {  // 우로 회전
                    queue.add(new Robot(ly, lx, ry - 1, rx + 1, cnt + 1));
                    queue.add(new Robot(ly + 1, lx + 1, ry, rx, cnt + 1));
                    row[ry - 1][rx + 1] = true;
                    row[ly + 1][lx + 1] = true;
                }
            }
        }

        return -1;
    }

    public class Robot {
        int leftX;
        int rightX;
        int leftY;
        int rightY;
        int cnt;

        Robot(int ly, int lx, int ry, int rx, int c) {
            this.leftX = Math.min(lx,rx);
            this.leftY = Math.min(ly,ry);
            this.rightX = Math.max(lx,rx);
            this.rightY = Math.max(ly,ry);
            this.cnt = c;
        }
    }
}
