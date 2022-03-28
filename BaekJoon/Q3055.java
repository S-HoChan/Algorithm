package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q3055 {    // 탈출
    static char[][] map;
    static int r, c;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        int startY = -1, startX = -1;
        for (int y = 0; y < r; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < c; x++) {
                map[y][x] = temp[x];
                if (map[y][x] == 'S') {
                    startY = y;
                    startX = x;
                    map[y][x] = '.';
                }
            }
        }

        boolean[][] visited = new boolean[r][c];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        int answer = 0;
        while (!queue.isEmpty()) {
            answer++;
            map = nextMap();
            int qSize = queue.size();
            while (qSize-- > 0) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if (ny < 0 || ny >= r || nx < 0 || nx >= c || visited[ny][nx]) continue;
                    if (map[ny][nx] == 'D') {
                        System.out.println(answer);
                        return;
                    }
                    if (map[ny][nx] == '.') {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

    static char[][] nextMap() {
        char[][] temp = new char[r][c];
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (temp[y][x] != '*') temp[y][x] = map[y][x];
                if (map[y][x] == '*') {
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if (ny < 0 || ny >= r || nx < 0 || nx >= c || map[ny][nx] != '.') continue;
                        temp[ny][nx] = '*';
                    }
                }
            }
        }
        return temp;
    }
}
