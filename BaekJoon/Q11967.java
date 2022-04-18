package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11967 {   // 불켜기
    static int n;
    static List<Room>[][] list;
    static boolean[][] isOn;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                list[x][y] = new ArrayList<>();
            }
        }
        isOn = new boolean[n][n];
        isOn[0][0] = true;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[x][y].add(new Room(a, b));
        }

        System.out.println(bfs() + 1);
    }

    static int bfs() {
        LinkedList<Room> queue = new LinkedList<>();
        queue.add(new Room(0, 0));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        boolean flag = false;
        int result = 0;
        while (!queue.isEmpty()) {
            Room now = queue.poll();
            for (Room next : list[now.x][now.y]) {
                if (!isOn[next.x][next.y]) {
                    isOn[next.x][next.y] = true;
                    result++;
                    flag = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || !isOn[nx][ny]) continue;

                queue.add(new Room(nx, ny));
                visited[nx][ny] = true;
            }
        }
        if (flag) result += bfs();
        return result;
    }

    static class Room {
        int x;
        int y;

        Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
