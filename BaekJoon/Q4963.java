package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q4963 {    // 섬의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            boolean[][] map = new boolean[h][w];
            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    if (Integer.parseInt(st.nextToken()) == 1) map[y][x] = true;
                }
            }

            int count = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (!map[y][x]) continue;

                    count++;
                    map[y][x] = false;
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{y, x});
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int i = 0; i < 8; i++) {
                            int ny = now[0] + dy[i];
                            int nx = now[1] + dx[i];
                            if (ny < 0 || ny >= h || nx < 0 || nx >= w || !map[ny][nx]) continue;

                            map[ny][nx] = false;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
