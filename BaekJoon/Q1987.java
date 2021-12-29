package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1987 {    // 알파벳
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Character> list = new ArrayList<>();
    static char[][] map;
    static int r, c;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int y = 0; y < r; y++) {
            String string = br.readLine();
            for (int i = 0; i < c; i++) {
                map[y][i] = string.charAt(i);
            }
        }
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int y, int x, int depth) {
        list.add(map[y][x]);
        char temp = map[y][x];
        map[y][x] = '-';    // blank
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx] == '-' || list.contains(map[ny][nx])) continue;

            dfs(ny, nx, depth + 1);
        }
        answer = Math.max(answer, depth);
        map[y][x] = temp;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == temp) {
                list.remove(i);
                break;
            }
        }
    }
}
