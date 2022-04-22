package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9204 {    // 체스
    static int[] dy = {-1, -1, 1, 1};
    static int[] dx = {-1, 1, -1, 1};
    static boolean[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = st.nextToken().charAt(0) - 'A';
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int endX = st.nextToken().charAt(0) - 'A';
            int endY = Integer.parseInt(st.nextToken()) - 1;

            if (Math.abs(startX - endX + startY - endY) % 2 == 1) {
                sb.append("Impossible").append('\n');
                continue;
            }
            if (startX == endX && startY == endY) {
                sb.append(0);
                print(startX, startY);
                sb.append('\n');
                continue;
            }

            map = new boolean[8][8];
            checkX(startX, startY);
            if (map[endX][endY]) {
                sb.append(1);
                print(startX, startY);
            } else {
                sb.append(2);
                print(startX, startY);
                searchMid(endX, endY);
            }
            print(endX, endY);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void checkX(int x, int y) {
        map[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x, ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) break;
                map[nx][ny] = true;
            }
        }
    }

    static void searchMid(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x, ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) break;
                if (map[nx][ny]) {
                    sb.append(' ').append((char) (nx + 'A')).append(' ').append(ny + 1);
                    return;
                }
            }
        }
    }

    static void print(int x, int y) {
        sb.append(' ').append((char) (x + 'A')).append(' ').append(y + 1);
    }
}
