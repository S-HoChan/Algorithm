package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2635 {    // 수 이어가기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();

        for (int i = n; i >= n / 2; i--) {
            List<Integer> temp = new ArrayList<>();
            temp.add(n);
            temp.add(i);

            int last = n, now = i;
            while (last - now >= 0) {
                int next = last - now;
                temp.add(next);

                last = now;
                now = next;
            }

            if (temp.size() > answer.size())
                answer = temp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (Integer i : answer) sb.append(i).append(' ');
        System.out.println(sb);
    }
}
