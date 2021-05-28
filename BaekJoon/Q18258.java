package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q18258 {   // 큐 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if (oper.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.add(x);
                last = x;
            } else if (oper.equals("pop")) {
                if (queue.isEmpty()) sb.append("-1").append('\n');
                else sb.append(queue.poll()).append('\n');
            } else if (oper.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (oper.equals("empty")) {
                if (queue.isEmpty()) sb.append("1").append('\n');
                else sb.append("0").append('\n');
            } else if (oper.equals("front")) {
                if (queue.isEmpty()) sb.append("-1").append('\n');
                else sb.append(queue.peek()).append('\n');
            } else if (oper.equals("back")) {
                if (queue.isEmpty()) sb.append("-1").append('\n');
                else sb.append(last).append('\n');
            }
        }
        System.out.println(sb);
    }
}
