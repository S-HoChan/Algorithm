package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15489 {   // 파스칼 삼각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int w = Integer.parseInt(st.nextToken());

        int[][] map = new int[r + w][r + w];
        for (int y = 0; y < r + w; y++) {
            for (int x = 0; x <= y; x++) {
                if (x == 0 || x == y) map[y][x] = 1;
                else {
                    map[y][x] = map[y - 1][x - 1] + map[y - 1][x];
                }
            }
        }

        int answer = 0;
        for (int y = r; y < r + w; y++) {
            for (int x = c; x < c + (y - r + 1); x++) {
                answer += map[y][x];
            }
        }
        System.out.println(answer);
    }
}
