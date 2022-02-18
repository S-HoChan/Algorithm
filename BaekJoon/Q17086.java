package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q17086 {   // 아기 상어 2
    static int n, m;
    static int answer = 0;
    static boolean[][] isShark;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isShark = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                if (Integer.parseInt(st.nextToken()) == 1) isShark[y][x] = true;
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!isShark[y][x]) cal(y, x);
            }
        }
        System.out.println(answer);
    }

    static void cal(int y, int x) {
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
                if (isShark[ny][nx]) {
                    answer = Math.max(answer, now[2] + 1);
                    return;
                }

                queue.add(new int[]{ny, nx, (now[2] + 1)});
                visited[ny][nx] = true;
            }
        }
    }
}
