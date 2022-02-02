package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2346 {    // 풍선 터뜨리기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> list = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        while (list.size() > 1) {
            Balloon now = list.pollFirst();
            sb.append(now.num).append(' ');
            int next = now.value;
            if (next > 0)
                for (int i = 0; i < next - 1; i++)
                    list.addLast(list.pollFirst());
            else
                for (int i = 0; i < -next; i++)
                    list.addFirst(list.pollLast());
        }
        sb.append(list.getFirst().num);
        System.out.println(sb);
    }

    static class Balloon {
        int num;
        int value;

        Balloon(int n, int v) {
            this.num = n;
            this.value = v;
        }
    }
}
