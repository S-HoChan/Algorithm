package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q12761 {   // 돌다리
    static int[] visited = new int[100001];
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == m) {
                System.out.println(visited[m]);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int next = getNext(i, now);
                if (isOk(next)) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println(visited[m]);
    }

    static boolean isOk(int next) {
        if (next >= 0 && next <= 100000 && visited[next] == 0) return true;
        return false;
    }

    static int getNext(int i, int now) {
        if (i == 0) return now - 1;
        else if (i == 1) return now + 1;
        else if (i == 2) return now - a;
        else if (i == 3) return now + a;
        else if (i == 4) return now - b;
        else if (i == 5) return now + b;
        else if (i == 6) return now * a;
        else return now * b;
    }
}
