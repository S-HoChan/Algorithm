package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q9417 {    // 최대 GCD
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
            list.sort(Comparator.reverseOrder());
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) < answer) break;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j) < answer) break;
                    answer = Math.max(answer, gcd(list.get(i), list.get(j)));
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b) {  // Euclidean algorithm
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
