package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18111 {   // 마인크래프트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int minHeight = 256, maxHeight = 0;
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[y][x]);
                maxHeight = Math.max(maxHeight, map[y][x]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = -1;
        for (int h = minHeight; h <= maxHeight; h++) {
            int usedTime = 0;
            int havingBlock = b;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    int diff = map[y][x] - h;
                    if (diff > 0) { // 제거
                        usedTime += diff * 2;
                        havingBlock += diff;
                    } else if (diff < 0) { // 설치
                        usedTime -= diff;
                        havingBlock += diff;
                    }
                }
            }

            if (havingBlock >= 0 && usedTime <= minTime) {
                minTime = usedTime;
                height = h;
            }
        }
        System.out.println(minTime + " " + height);
    }
}
