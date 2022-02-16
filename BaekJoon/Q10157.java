package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10157 {   // 자리배정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        if (k > r * c) {
            System.out.println(0);
            return;
        }
        boolean[][] map = new boolean[r][c];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int direct = 0;
        int y = r - 1, x = 0, ny = r - 1, nx = 0;
        for (int num = 1; num <= k; num++) {
            y = ny;
            x = nx;
            map[y][x] = true;
            ny = y + dy[direct];
            nx = x + dx[direct];
            if (ny < 0 || ny >= r || nx < 0 || nx >= c || map[ny][nx]) {
                direct = (direct + 1) % 4;
                ny = y + dy[direct];
                nx = x + dx[direct];
            }
        }
        System.out.println((x + 1) + " " + (r - y));
    }
}
