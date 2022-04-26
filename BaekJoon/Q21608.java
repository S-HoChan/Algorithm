package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q21608 {   // 상어 초등학교
    static int[][] room;
    static int n;
    static Map<Integer, Set<Integer>> map = new HashMap<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * n];
        room = new int[n][n];
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            map.put(key, new HashSet<>());
            map.get(key).add(Integer.parseInt(st.nextToken()));
            map.get(key).add(Integer.parseInt(st.nextToken()));
            map.get(key).add(Integer.parseInt(st.nextToken()));
            map.get(key).add(Integer.parseInt(st.nextToken()));
            arr[i] = key;
        }

        for (int i = 0; i < n * n; i++) {
            setStudent(arr[i]);
        }

        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int fav = 0;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (isIn(ny, nx) && map.get(room[y][x]).contains(room[ny][nx])) fav++;
                }
                if (fav > 0) answer += Math.pow(10, fav - 1);
            }
        }
        System.out.println(answer);
    }

    static void setStudent(int key) {
        // int[] : y, x, 선호도, 빈칸
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    if (o1[3] == o2[3]) {
                        if (o1[0] == o2[0]) return o1[1] - o2[1];
                        return o1[0] - o2[0];
                    }
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
        });

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int fav = 0, blank = 0; // 선호도, 빈칸
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (isIn(ny, nx)) {
                        if (room[ny][nx] == 0) blank++;
                        else if (map.get(key).contains(room[ny][nx])) fav++;
                    }
                }
                pq.add(new int[]{y, x, fav, blank});
            }
        }

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int ty = temp[0], tx = temp[1];
            if (room[ty][tx] == 0) {
                room[ty][tx] = key;
                break;
            }
        }
    }

    static boolean isIn(int y, int x) {
        return !(y < 0 || y >= n || x < 0 || x >= n);
    }
}
