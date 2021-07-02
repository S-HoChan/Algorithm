package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3109 {     // 빵집
    static char[][] map;
    static int[] dir = {-1,0,1};
    static int r, c;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String string = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = string.charAt(j);
            }
        }

        for (int y = 0; y < r; y++) dfs(y, 0);

        System.out.println(answer);
    }

    private static boolean dfs(int y, int x) {
        if (x == c - 1) {
            answer++;
            return true;
        }

        for(int i = 0; i < 3; i++){
            int ty = y + dir[i];
            int tx = x + 1;

            if (ty < 0 || ty >= r || tx < 0 || tx >= c || map[ty][tx] == 'x' ) continue;   // 못가는 곳

            map[ty][tx] = 'x';

            if(dfs(ty, tx)) return true;    // 도착하면 중단
        }

        return false;
    }
}
