package BaekJoon;

import java.util.Scanner;

public class Q1712 {    // 손익분기점
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (b >= c) {
            System.out.println(-1);
            return;
        }

        int ans = a / (c - b) + 1;
        System.out.println(ans);
    }
}
