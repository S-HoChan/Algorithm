package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q20058 {   // 마법사 상어와 파이어스톰
    static int[][] map;
    static int n, powN;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        powN = (int) Math.pow(2, n);
        map = new int[powN][powN];
        for (int y = 0; y < powN; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < powN; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            map = fireStorm(Integer.parseInt(st.nextToken()));
            map = melt();
        }

        int sum = 0, blockSize = 0;
        boolean[][] visited = new boolean[powN][powN];
        for (int y = 0; y < powN; y++) {
            for (int x = 0; x < powN; x++) {
                if (visited[y][x] || map[y][x] <= 0) continue;
                int tempSize = 0;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.add(new int[]{y, x});
                visited[y][x] = true;
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    int nowY = now[0];
                    int nowX = now[1];
                    tempSize++;
                    sum += map[nowY][nowX];
                    for (int i = 0; i < 4; i++) {
                        int ny = nowY + dy[i];
                        int nx = nowX + dx[i];
                        if (ny >= 0 && ny < powN && nx >= 0 && nx < powN && !visited[ny][nx] && map[ny][nx] > 0) {
                            queue.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
                blockSize = Math.max(blockSize, tempSize);
            }
        }

        System.out.println(sum);
        System.out.println(blockSize);
    }

    static int[][] fireStorm(int l) {
        int[][] tempArray = new int[powN][powN];
        int powL = (int) Math.pow(2, l);
        for (int y = 0; y < powN; y += powL) {
            for (int x = 0; x < powN; x += powL) {
                rotate(y, x, powL, tempArray);
            }
        }
        return tempArray;
    }

    static void rotate(int y, int x, int size, int[][] tempArray) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tempArray[y + j][x + size - i - 1] = map[y + i][x + j];
            }
        }
    }

    static int[][] melt() {
        int[][] tempArray = new int[powN][powN];
        for (int i = 0; i < powN; i++) {
            tempArray[i] = Arrays.copyOf(map[i], powN);
        }

        for (int y = 0; y < powN; y++) {
            for (int x = 0; x < powN; x++) {
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny >= 0 && ny < powN && nx >= 0 && nx < powN && map[ny][nx] > 0)
                        cnt++;
                }
                if (cnt < 3) tempArray[y][x]--;
            }
        }
        return tempArray;
    }
}
