package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1939 {    // 중량제한
    static int n, start, end;
    static ArrayList<int[]> list[]; // {섬, 무게}
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        int min = Integer.MAX_VALUE;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
            max = Math.max(max, c);
            min = Math.min(min, c);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;

        int answer = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            visited = new boolean[n];
            if (bfs(mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean bfs(int mid) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) return true;

            for (int i = 0; i < list[now].size(); i++) {
                if (list[now].get(i)[1] >= mid && !visited[list[now].get(i)[0]]) {
                    visited[list[now].get(i)[0]] = true;
                    queue.add(list[now].get(i)[0]);
                }
            }
        }
        return false;
    }
}
