package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11286 {   // 절댓값 힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> pqPlus = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now > 0) pqPlus.add(now);
            else if (now < 0) pqMinus.add(now);
            else {
                if (pqPlus.isEmpty() && pqMinus.isEmpty())
                    sb.append('0');
                else if (pqPlus.isEmpty())
                    sb.append(pqMinus.poll());
                else if (pqMinus.isEmpty())
                    sb.append(pqPlus.poll());
                else {
                    if (pqPlus.peek() >= -pqMinus.peek())
                        sb.append(pqMinus.poll());
                    else sb.append(pqPlus.poll());
                }

                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
