package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1644 {    // 소수의 연속합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!visited[i]) {
                list.add(i);
                for (int j = i; j <= n; j += i) {
                    visited[j] = true;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i);
            for (int j = i + 1; j < list.size() && sum < n; j++) {
                sum += list.get(j);
            }
            if (sum == n) answer++;
        }
        System.out.println(answer);
    }
}
