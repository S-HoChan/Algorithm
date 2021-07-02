package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {    // 유기농 배추
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static int m, n;
    static void bfs(int y, int x){
        visited[y][x] = true;

        for(int z = 0; z < 4; z++){
            int i = y + dy[z];
            int j = x + dx[z];
            if(i >= 0 && i < m && j >= 0 && j < n){
                if(visited[i][j] || !map[i][j]) continue;

                bfs(i, j);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int ans = 0;
            map = new boolean[m][n];
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] || !map[i][j]) continue;

                    bfs(i, j);
                    ans++;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
