package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5904 {    // Moo 게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sol(n);
    }

    static void sol(int n) {
        int size = 3;
        int cnt = 0;
        if (n == 1) System.out.println('m');
        else if (n <= 3) System.out.println('o');
        else {
            while (size < n) {
                size = size * 2 + cnt++ + 4;
            }
            int front = (size - cnt - 3) / 2;
            if (size - front + 1 <= n) {
                sol(n - size + front);
            } else if (n == front + 1) System.out.println('m');
            else System.out.println('o');
        }
    }
}
