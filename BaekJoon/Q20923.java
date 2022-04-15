package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q20923 {   // 숫자 할리갈리 게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> dodo = new LinkedList<>();
        Deque<Integer> suyeon = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dodo.addFirst(Integer.parseInt(st.nextToken()));
            suyeon.addFirst(Integer.parseInt(st.nextToken()));
        }   // First는 가장 윗 카드의 숫자를 뜻한다.

        Deque<Integer> g1 = new LinkedList<>();  // dodo ground
        Deque<Integer> g2 = new LinkedList<>();  // suyeon ground
        // ground는 Last가 가장 윗 카드의 숫자다. (뒤집기 때문에)
        for (int count = 0; count < m; count++) {  // even : do, odd : su
            // step 2
            if (count % 2 == 0) {
                if (!dodo.isEmpty()) g1.addLast(dodo.pollFirst());
            } else {
                if (!suyeon.isEmpty()) g2.addLast(suyeon.pollFirst());
            }

            if (dodo.isEmpty()) {
                System.out.println("su");
                return;
            } else if (suyeon.isEmpty()) {
                System.out.println("do");
                return;
            }

            // step 3, 4
            if (!g1.isEmpty() && !g2.isEmpty() && g1.peekLast() + g2.peekLast() == 5) { // suyeon win
                while (!g1.isEmpty()) suyeon.addLast(g1.pollFirst());
                while (!g2.isEmpty()) suyeon.addLast(g2.pollFirst());
            } else if ((!g1.isEmpty() && g1.peekLast() == 5) || (!g2.isEmpty() && g2.peekLast() == 5)) {   // dodo win
                while (!g2.isEmpty()) dodo.addLast(g2.pollFirst());
                while (!g1.isEmpty()) dodo.addLast(g1.pollFirst());
            }
        }
        if (dodo.size() > suyeon.size()) System.out.println("do");
        else if (dodo.size() == suyeon.size()) System.out.println("dosu");
        else System.out.println("su");
    }
}
