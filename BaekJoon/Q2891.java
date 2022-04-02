package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2891 {    // 카약과 강풍
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean[] destroyed = new boolean[n];
        st = new StringTokenizer(br.readLine());
        while (s-- > 0) destroyed[Integer.parseInt(st.nextToken()) - 1] = true;
        st = new StringTokenizer(br.readLine());
        int[] surplus = new int[r];
        for (int i = 0; i < r; i++) {
            surplus[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        Arrays.sort(surplus);
        for (int now : surplus) {
            if (destroyed[now]) destroyed[now] = false;
            else if (now > 0 && destroyed[now - 1]) destroyed[now - 1] = false;
            else if (now < n - 1 && destroyed[now + 1]) destroyed[now + 1] = false;
        }

        int answer = 0;
        for (boolean isOk : destroyed)
            if (isOk) answer++;
        System.out.println(answer);
    }
}
