package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11657 {   // 타임머신
    static final int INF = 500 * 100000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Bus[] buses = new Bus[m];
        long dist[] = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            buses[i] = new Bus(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 벨만포드 알고리즘
        dist[1] = 0;
        for (int i = 0; i < n - 1; i++) {   // n-1번 실행
            for (int j = 0; j < m; j++) {
                if (dist[buses[j].u] == INF) continue;

                if (dist[buses[j].v] > dist[buses[j].u] + buses[j].val) {
                    dist[buses[j].v] = dist[buses[j].u] + buses[j].val;
                }   // 최단거리 갱신
            }
        }

        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (dist[buses[i].u] != INF && dist[buses[i].v] > dist[buses[i].u] + buses[i].val) {
                flag = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (flag) {
            sb.append(-1).append('\n');
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dist[i]).append('\n');
                }
            }
        }

        System.out.println(sb);
    }

    static class Bus {
        int u;
        int v;
        int val;

        Bus(int u, int v, int val) {
            this.u = u;
            this.v = v;
            this.val = val;
        }
    }
}
