package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5086 {    // 배수와 약수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (first == 0 && second == 0) break;

            if (first > second && first % second == 0) {
                System.out.println("multiple");
            } else if (first < second && second % first == 0) {
                System.out.println("factor");
            } else System.out.println("neither");
        }
    }
}
