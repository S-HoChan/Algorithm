package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2865 {    // 나는 위대한 슈퍼스타K
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Pair> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;
        float answer = 0;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                float ability = Float.parseFloat(st.nextToken());
                list.add(new Pair(num, ability));
            }
        }
        list.sort((o1, o2) -> Float.compare(o2.ability, o1.ability));

        for (Pair now : list) {
            if (cnt >= k) break;
            if (!visited[now.num]) {
                answer += now.ability;
                visited[now.num] = true;
                cnt++;
            }
        }
        System.out.printf("%.1f\n", answer);
    }

    static class Pair {
        int num;
        float ability;

        Pair(int num, float ability) {
            this.num = num;
            this.ability = ability;
        }
    }
}
