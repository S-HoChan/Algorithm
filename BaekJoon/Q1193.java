package BaekJoon;

import java.util.*;

public class Q1193 {    // 분수찾기
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        for (int i = 1; ; i++) {
            if (x <= i) {
                if (i % 2 == 0) {
                    System.out.println(x + "/" + (i - x + 1));
                } else {
                    System.out.println((i - x + 1) + "/" + x);
                }
                break;
            } else {
                x -= i;
            }
        }
    }
}
