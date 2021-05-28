package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021 {    // 회전하는 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        int n = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int now = list.indexOf(Integer.parseInt(st.nextToken()));
            int halfIdx = list.size() / 2 - (list.size() + 1) % 2;

            if (now <= halfIdx) {
                for (int j = 0; j < now; j++) {
                    list.addLast(list.pollFirst());
                    ans++;
                }
            } else {
                for (int j = 0; j < list.size() - now; j++) {
                    list.addFirst(list.pollLast());
                    ans++;
                }
            }
            list.pollFirst();
        }

        System.out.println(ans);
    }
}
