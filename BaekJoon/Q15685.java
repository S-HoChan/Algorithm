package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15685 {   // 드래곤 커브
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};   // 우 상 좌 하
    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1])
                    answer++;
            }
        }
        System.out.println(answer);
    }

    static void draw(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);    // reverseClock
            }
        }

        map[y][x] = true;
        for (int direct : list) {
            y += dy[direct];
            x += dx[direct];
            map[y][x] = true;
        }
    }
}
