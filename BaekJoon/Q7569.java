package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q7569 {    // 토마토
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[m][n][h];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int _h = 0; _h < h; _h++) {
            for (int _n = 0; _n < n; _n++) {
                st = new StringTokenizer(br.readLine());
                for (int _m = 0; _m < m; _m++) {
                    map[_m][_n][_h] = Integer.parseInt(st.nextToken());
                    if (map[_m][_n][_h] == 1) {
                        queue.add(new int[]{_m, _n, _h, 1});
                    }
                }
            }
        }

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                int z = now[2] + dz[i];

                if (x < 0 || x >= m || y < 0 || y >= n || z < 0 || z >= h || map[x][y][z] != 0) continue;

                map[x][y][z] = now[3] + 1;
                queue.add(new int[]{x, y, z, map[x][y][z]});
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < h; k++) {
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }

                    ans = Math.max(ans, map[i][j][k]);
                }
            }
        }

        if(ans == 1) System.out.println(0);
        else System.out.println(ans - 1);
    }
}
