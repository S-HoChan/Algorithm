package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q16236 {   // 아기 상어
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        LinkedList<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    queue.add(new Node(i, j, 0));
                    map[i][j] = 0;
                }
            }
        }

        int sharkSize = 2;
        int eatCount = 0;
        int answer = 0;
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};  // 북서동남 순
        while (true) {
            LinkedList<Node> fishes = new LinkedList<>();
            int[][] dist = new int[n][n];

            while (!queue.isEmpty()) {
                Node now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n || dist[ny][nx] != 0 || map[ny][nx] > sharkSize)
                        continue;

                    dist[ny][nx] = dist[now.y][now.x] + 1;
                    queue.add(new Node(ny, nx, dist[ny][nx]));
                    if (map[ny][nx] >= 1 && map[ny][nx] <= 6 && map[ny][nx] < sharkSize)
                        fishes.add(new Node(ny, nx, dist[ny][nx]));
                }
            }

            if (fishes.size() == 0) {
                System.out.println(answer);
                return;
            }

            Node nowFish = fishes.get(0);
            for (int i = 1; i < fishes.size(); i++) {
                if (nowFish.dist > fishes.get(i).dist) {
                    nowFish = fishes.get(i);
                } else if (nowFish.dist == fishes.get(i).dist) {
                    if (nowFish.y > fishes.get(i).y) nowFish = fishes.get(i);
                    else if (nowFish.y == fishes.get(i).y) {
                        if (nowFish.x > fishes.get(i).x) nowFish = fishes.get(i);
                    }
                }
            }

            answer += nowFish.dist;
            eatCount++;
            map[nowFish.y][nowFish.x] = 0;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
            queue.add(new Node(nowFish.y, nowFish.x, 0));
        }
    }

    static class Node {
        int y;
        int x;
        int dist;

        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
