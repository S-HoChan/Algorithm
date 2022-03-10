package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2872 {    // 우리집엔 도서관이 있어
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        int target = n;
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(i) == target) target--;
            else answer++;
        }
        System.out.println(answer);
    }
}
