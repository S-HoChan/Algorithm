package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q20056 {   // 마법사 상어와 파이어볼
    public static void main(String[] args) throws IOException {
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Fire>[][] map = new ArrayList[n][n];
        ArrayList<Fire> list = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                map[y][x] = new ArrayList<>();
            }
        }
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Fire(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        while (k-- > 0) {
            for (Fire fire : list) {    // 1. move
                int ny = (n + fire.y + dy[fire.d] * (fire.s % n)) % n;
                int nx = (n + fire.x + dx[fire.d] * (fire.s % n)) % n;

                fire.y = ny;
                fire.x = nx;
                map[ny][nx].add(fire);
            }

            for (int y = 0; y < n; y++) { // 2. oper
                for (int x = 0; x < n; x++) {
                    if (map[y][x].size() == 1) map[y][x].clear();
                    else if (map[y][x].size() > 1) {
                        int totalMass = 0, totalSpeed = 0;
                        boolean isEven = map[y][x].get(0).d % 2 == 0;
                        boolean isOdd = map[y][x].get(0).d % 2 == 1;

                        for (Fire now : map[y][x]) {
                            totalMass += now.m;
                            totalSpeed += now.s;

                            isEven = isEven && now.d % 2 == 0;
                            isOdd = isOdd && now.d % 2 == 1;
                            list.remove(now);
                        }

                        int newMass = totalMass / 5;
                        int newSpeed = totalSpeed / map[y][x].size();
                        map[y][x].clear();
                        if (newMass == 0) continue;

                        if (isEven || isOdd) {
                            list.add(new Fire(y, x, newMass, newSpeed, 0));
                            list.add(new Fire(y, x, newMass, newSpeed, 2));
                            list.add(new Fire(y, x, newMass, newSpeed, 4));
                            list.add(new Fire(y, x, newMass, newSpeed, 6));
                        } else {
                            list.add(new Fire(y, x, newMass, newSpeed, 1));
                            list.add(new Fire(y, x, newMass, newSpeed, 3));
                            list.add(new Fire(y, x, newMass, newSpeed, 5));
                            list.add(new Fire(y, x, newMass, newSpeed, 7));
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (Fire fire : list) answer += fire.m;
        System.out.println(answer);
    }

    static class Fire {
        int y;
        int x;
        int m;
        int s;
        int d;

        Fire(int r, int c, int m, int s, int d) {
            this.y = r;
            this.x = c;
            this.m = m; // mass
            this.s = s; // speed
            this.d = d; // direct
        }
    }
}
