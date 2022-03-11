package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14712 {   // 넴모넴모 (Easy)
    static int n, m, answer = 0;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int count) {
        if (count == n * m) {  // 끝에 도달
            answer++;
            return;
        }

        int y = count / m;
        int x = count % m;
        if (isOk(y, x)) {
            map[y][x] = true;
            dfs(count + 1);
            map[y][x] = false;
        }
        dfs(count + 1);
    }

    static boolean isOk(int y, int x) { // 터질 경우 false
        if (y == 0 || x == 0) return true;
        return !map[y - 1][x] || !map[y][x - 1] || !map[y - 1][x - 1];
    }
}
