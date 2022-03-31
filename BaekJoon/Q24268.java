package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q24268 {   // 2022는 무엇이 특별할까?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int min = (int) Math.pow(d, d - 1);
        for (int i = 0; i < d - 2; i++) {
            min += (int) Math.pow(d, i) * (d - 1 - i);
        }
        if (n < min) n = min - 1;
        // 10234 = 5^4 + 2*5^2 + 3*5^1 + 4
        while (true) {
            n++;
            Set<Integer> set = new HashSet<>();
            int temp = n;
            int count = 0;
            while (temp > 0) {
                set.add(temp % d);
                temp /= d;
                count++;
            }

            if (count > d) {
                System.out.println(-1);
                break;
            } else if (set.size() == d) {
                System.out.println(n);
                break;
            }
        }
    }
}
