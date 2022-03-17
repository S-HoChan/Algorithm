package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1446 {    // 지름길
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (end > d || end - start <= distance) continue;

            list.add(new int[]{start, end, distance});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int now = 0, idx = 0;
        int[] dp = new int[d + 1];
        Arrays.fill(dp, d + 1);
        dp[0] = 0;
        while (now < d) {
            while (idx < list.size()) {
                int[] temp = list.get(idx);
                if (now == temp[0]) {
                    dp[temp[1]] = Math.min(dp[temp[1]], dp[now] + temp[2]);
                    idx++;
                } else {
                    dp[now + 1] = Math.min(dp[now + 1], dp[now++] + 1);
                }
            }

            dp[now + 1] = Math.min(dp[now + 1], dp[now++] + 1);
        }

        System.out.println(dp[d]);
    }
}
