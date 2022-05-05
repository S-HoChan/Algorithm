package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q9009 {    // 피보나치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            while (true) {
                int next = list.get(list.size() - 2) + list.get(list.size() - 1);
                if (next > n) break;
                list.add(next);
            }

            Collections.sort(list, Collections.reverseOrder());
            List<Integer> answer = new ArrayList<>();
            while (n > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) <= n) {
                        n -= list.get(i);
                        answer.add(list.get(i));
                    }
                }
            }

            Collections.sort(answer);
            answer.remove(0);
            for (int i : answer)
                sb.append(i).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
