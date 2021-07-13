package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};

        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            map[startY][startX] = true;
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startY, startX, 0});
            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[0] == endY && now[1] == endX) {
                    sb.append(now[2]).append('\n');
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int y = now[0] + dy[i];
                    int x = now[1] + dx[i];
                    if (y < 0 || y >= l || x < 0 || x >= l || map[y][x]) continue;

                    queue.add(new int[]{y, x, now[2] + 1});
                    map[y][x] = true;
                }
            }
        }

        System.out.println(sb);
    }
}
