package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1091 {    // 카드 섞기
    static int n;
    static int[] p, s;
    static int[] shuffledCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        s = new int[n];   // shuffle pattern
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        shuffledCard = new int[n];
        for (int i = 0; i < n; i++) {
            shuffledCard[i] = i;
        }
        int answer = 0;

        while (true) {
            if (isOk()) {
                System.out.println(answer);
                return;
            }

            if (isFirst() && answer > 0) {
                System.out.println(-1);
                return;
            }

            shuffledCard = shuffle();
            answer++;
        }
    }

    static int[] shuffle() {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[s[i]] = shuffledCard[i];
        }
        return temp;
    }

    static boolean isOk() {
        for (int i = 0; i < n; i++) {
            if (p[shuffledCard[i]] != i % 3) return false;
        }
        return true;
    }

    static boolean isFirst() {
        for (int i = 0; i < n; i++) {
            if (shuffledCard[i] != i) return false;
        }
        return true;
    }
}
