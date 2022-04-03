package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4396 {    // 지뢰 찾기
    public static void main(String[] args) throws IOException {
        int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        char[][] answer = new char[n][n];
        for (int y = 0; y < n; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < n; x++) {
                if (temp[x] == '*') {
                    for (int i = 0; i < 8; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                        map[ny][nx]++;
                    }
                    map[y][x] = -99;
                }
            }
        }

        boolean flag = false;
        for (int y = 0; y < n; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < n; x++) {
                char now = temp[x];
                if (now == '.') answer[y][x] = '.';
                else if (map[y][x] < 0) flag = true;
                else answer[y][x] = (char) (map[y][x] + '0');
            }
        }

        if (flag)
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] < 0) answer[y][x] = '*';
                }
            }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++)
                sb.append(answer[y][x]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
