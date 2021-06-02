package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q11723 {   // 집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("empty")) {
                set = new HashSet<>();
            } else if (order.equals("all")) {
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            } else {
                int x = Integer.parseInt(st.nextToken());
                if (order.equals("add")) set.add(x);
                else if (order.equals("remove")) {
                    set.remove(x);
                } else if (order.equals("check")) {
                    if (set.contains(x)) sb.append('1').append('\n');
                    else sb.append('0').append('\n');
                } else if (order.equals("toggle")) {
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                }
            }
        }
        System.out.println(sb);
    }
}
