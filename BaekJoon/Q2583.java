package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2583 {    // 영역 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());   // 세로
        int n = Integer.parseInt(st.nextToken());   // 가로
        int k = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[m][n];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int x = startX; x < endX; x++) {
                for (int y = startY; y < endY; y++) {
                    map[y][x] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new LinkedList<>();
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (!map[y][x]) {
                    map[y][x] = true;
                    int cnt = 1;
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{y, x});
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int i = 0; i < 4; i++) {
                            int ny = now[0] + dy[i];
                            int nx = now[1] + dx[i];
                            if (ny < 0 || nx < 0 || ny >= m || nx >= n || map[ny][nx]) continue;

                            queue.add(new int[]{ny, nx});
                            cnt++;
                            map[ny][nx] = true;
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        while (!list.isEmpty()) {
            sb.append(((LinkedList<Integer>) list).pollFirst()).append(' ');
        }
        System.out.println(sb);
    }
}
