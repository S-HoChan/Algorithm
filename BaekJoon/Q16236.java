package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// todo. 실패
public class Q16236 {   // 아기 상어
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int sharkY = 0, sharkX = 0;
        PriorityQueue<Integer> fishSize = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                } else if (map[i][j] > 0) {
                    fishSize.add(map[i][j]);
                }
            }
        }

        int sharkSize = 2;
        int eatCount = 0;
        int answer = 0;
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};  // 북서동남 순
        while (!fishSize.isEmpty() && fishSize.peek() < sharkSize) {
            boolean[][] visited = new boolean[n][n];
            visited[sharkY][sharkX] = true;
            LinkedList<int[]> list = new LinkedList<>();
            list.add(new int[]{sharkY, sharkX});

            boolean isEat = false;
            while (!list.isEmpty() && !isEat) {
                int[] now = list.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n ||
                            map[ny][nx] > sharkSize || visited[ny][nx]) continue;

                    visited[ny][nx] = true;
                    if (map[ny][nx] < sharkSize && map[ny][nx] > 0) {
                        eatCount++;
                        fishSize.remove(map[ny][nx]);

                        map[sharkY][sharkX] = 0;

                        answer += Math.abs(sharkY - ny) + Math.abs(sharkX - nx);
                        sharkY = ny;
                        sharkX = nx;
                        isEat = true;
                        break;
                    } else {
                        list.add(new int[]{ny, nx});
                    }
                }
            }

            if (eatCount == sharkSize) {
                eatCount = 0;
                sharkSize++;
            }
        }
        System.out.println(answer);
    }
}
