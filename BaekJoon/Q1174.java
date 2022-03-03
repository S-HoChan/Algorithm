package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1174 {    // 줄어드는 수
    static List<Long> list = new ArrayList<>();
    static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(0, 0);
        list.sort(null);

        System.out.println(n > 1023 ? -1 : list.get(n - 1));
    }

    static void dfs(long now, int idx) {
        if (!list.contains(now)) list.add(now);
        if (idx >= 10) return;
        dfs((now * 10) + num[idx], idx + 1);
        dfs(now, idx + 1);
    }
}
