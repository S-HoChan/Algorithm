package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {   // 로봇 청소기
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][][] map = new boolean[n][m][2];    // [][][0] = true : 벽, [][][1] = true : 바닥인데 청소함

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   // 0123 : NESW

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j][0] = (Integer.parseInt(st.nextToken()) == 1);
            }
        }

        operate(map, r, c, d);

        System.out.println(answer);
    }

    public static void operate(boolean[][][] map, int y, int x, int direct) {
        if (!map[y][x][1]) {
            map[y][x][1] = true;    // 1
            answer++;
        }

        boolean flag = false;
        for (int i = 0; i < 4; i++) {   // 2.b
            int nd = (direct + 3 - i) % 4;
            int ny = y + dy[nd];
            int nx = x + dx[nd];
            if (!map[ny][nx][0] && !map[ny][nx][1]) {
                operate(map, ny, nx, nd); // 2.a
                flag = true;
                break;
            }
        }

        if (!flag) {
            int ny = y + dy[(direct + 2) % 4];
            int nx = x + dx[(direct + 2) % 4];
            if (!map[ny][nx][0]) operate(map, ny, nx, direct); //2.cd
        }
    }
}
