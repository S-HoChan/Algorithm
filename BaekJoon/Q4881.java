package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4881 {    // 자리수의 제곱
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            sb.append(a).append(' ').append(b).append(' ');
            List<Integer> list1 = new ArrayList<>();
            while (!list1.contains(a)) {
                list1.add(a);
                int na = 0;
                while (a > 0) {
                    na += (a % 10) * (a % 10);
                    a /= 10;
                }
                a = na;
            }
            List<Integer> list2 = new ArrayList<>();
            while (!list2.contains(b)) {
                list2.add(b);
                int nb = 0;
                while (b > 0) {
                    nb += (b % 10) * (b % 10);
                    b /= 10;
                }
                b = nb;
            }

            int answer = list1.size() + list2.size() + 1;
            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i)))
                    answer = Math.min(answer, i + list2.indexOf(list1.get(i)) + 2);
            }
            for (int i = 0; i < list2.size(); i++) {
                if (list1.contains(list2.get(i)))
                    answer = Math.min(answer, i + list1.indexOf(list2.get(i)) + 2);
            }
            sb.append(answer == list1.size() + list2.size() + 1 ? 0 : answer).append('\n');
        }
        System.out.println(sb);
    }
}
