package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1946 {    // 신입 사원
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Employee> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                list.add(new Employee(n1, n2));
            }

            list.sort((o1, o2) -> {
                if (o1.n1 > o2.n1) return 1;
                else return -1;
            });

            int ans = 1;    // 서류 1등
            int min = list.get(0).n2;   // 면접 최소값
            for (int i = 1; i < n; i++) {
                if (list.get(i).n2 < min) {
                    ans++;
                    min = list.get(i).n2;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static class Employee {
        int n1;
        int n2;

        Employee(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }
}
