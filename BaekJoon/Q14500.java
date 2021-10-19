package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {   // 테트로미노
    static int[][] map;
    static int answer = 0;
    static int cols, rows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        map = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                for (int i = 0; i < 4; i++) {
                    dfs(y, x, i, 0, 0);
                    except(y, x);
                }
            }
        }

        System.out.println(answer);
    }

    // direct : 동북서남 [0, 1, 2, 3]
    public static void dfs(int y, int x, int direct, int count, int sum) {
        if (y < 0 || y >= cols || x < 0 || x >= rows) return;

        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        if (direct != 0) dfs(y, x - 1, 2, count + 1, sum + map[y][x]); // 동쪽이 아니면 서쪽 가능
        if (direct != 1) dfs(y + 1, x, 3, count + 1, sum + map[y][x]);
        if (direct != 2) dfs(y, x + 1, 0, count + 1, sum + map[y][x]);
        if (direct != 3) dfs(y - 1, x, 1, count + 1, sum + map[y][x]);
    }

    public static void except(int y, int x) {    // ㅗ모양
        int wing = 4;   // 4방향 날개
        int min = Integer.MAX_VALUE;
        int sum = map[y][x];

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (wing <= 2) return;   // 2개 이하면 ㅗ모양이 아님
            if (ny < 0 || ny >= cols || nx < 0 || nx >= rows) { // map밖일 경우 아님
                wing--;
                continue;
            }
            min = Math.min(min, map[ny][nx]);
            sum = sum + map[ny][nx];
        }

        if (wing == 4) sum = sum - min;    // 날개가 4개면 가장 작은 날개 없애기
        answer = Math.max(answer, sum);
    }
}
