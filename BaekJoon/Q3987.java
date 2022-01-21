package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3987 {    // 보이저 1호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int y = 0; y < n; y++) {
            char[] arr = br.readLine().toCharArray();
            for (int x = 0; x < m; x++) {
                map[y][x] = arr[x];
            }
        }
        st = new StringTokenizer(br.readLine());
        int pr = Integer.parseInt(st.nextToken()) - 1;
        int pc = Integer.parseInt(st.nextToken()) - 1;

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};  // URDL
        int answer = 0;
        int ansDir = 0;
        for (int i = 0; i < 4; i++) {
            boolean[][][] visited = new boolean[n][m][4];
            int y = pr;
            int x = pc;
            int dir = i;
            visited[y][x][dir] = true;
            int cnt = map[y][x] == '.' ? 1 : 0;
            while (true) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == 'C') {
                    if (answer < cnt) {
                        answer = cnt;
                        ansDir = i;
                    }
                    break;
                }
                if (visited[ny][nx][dir] && map[ny][nx] == '.') {
                    System.out.println(getDir(i));
                    System.out.println("Voyager");
                    return;
                }
                if (map[ny][nx] == '/') {
                    if (dir == 0) dir = 1;
                    else if (dir == 1) dir = 0;
                    else if (dir == 2) dir = 3;
                    else dir = 2;
                } else if (map[ny][nx] == '\\') {
                    if (dir == 0) dir = 3;
                    else if (dir == 3) dir = 0;
                    else if (dir == 1) dir = 2;
                    else dir = 1;
                }
                y = ny;
                x = nx;
                visited[y][x][dir] = true;
                cnt++;
            }
        }
        System.out.println(getDir(ansDir));
        System.out.println(answer);
    }

    static char getDir(int i) {
        if (i == 0) return 'U';
        else if (i == 1) return 'R';
        else if (i == 2) return 'D';
        else return 'L';
    }
}
