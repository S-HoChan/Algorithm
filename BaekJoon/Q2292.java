package BaekJoon;

import java.util.*;

public class Q2292 {    // 벌집
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = 1;
        int num = 1;
        for(int i = 1;;i++){
            if(n <= num) {
                System.out.println(ans);
                break;
            }

            num += 6 * i;
            ans++;
        }
    }
}
