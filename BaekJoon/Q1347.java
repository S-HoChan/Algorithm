package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1347 {    // 미로 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, -1, 0, 1};   // 하좌상우
        boolean[][] visited = new boolean[n * 2 + 1][n * 2 + 1];
        int nowY = n, nowX = n, minY = n, minX = n, maxY = n, maxX = n;
        int direct = 0; // 초기값 : 하
        visited[nowY][nowX] = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'F') {
                nowY += dy[direct];
                nowX += dx[direct];
                visited[nowY][nowX] = true;
                minY = Math.min(minY, nowY);
                minX = Math.min(minX, nowX);
                maxY = Math.max(maxY, nowY);
                maxX = Math.max(maxX, nowX);
            } else {
                direct += 4;    // 음수를 갖지 않기 위해
                direct = arr[i] == 'R' ? direct + 1 : direct - 1;   // 방향 전환
                direct %= 4;    // 0~3의 값을 갖기 위해
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                sb.append(visited[y][x] ? '.' : '#');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
