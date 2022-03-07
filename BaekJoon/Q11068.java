package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11068 {   // 회문인 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            for (int b = 2; b <= 64; b++) {
                Deque<Integer> deque = new ArrayDeque<>();
                int temp = n;
                while (temp > 0) {
                    deque.addFirst(temp % b);
                    temp /= b;
                }

                if (isPalin(deque)) {
                    sb.append(1).append('\n');
                    flag = true;
                    break;
                }
            }
            if (!flag) sb.append(0).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isPalin(Deque<Integer> deque) {
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) return false;
        }
        return true;
    }
}
