package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10866 {   // 덱
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if (oper.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            } else if (oper.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            } else {
                if (oper.equals("pop_front")) {
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.pollFirst());
                } else if (oper.equals("pop_back")) {
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.pollLast());
                } else if (oper.equals("size")) {
                    sb.append(deque.size());
                } else if (oper.equals("empty")) {
                    if (deque.isEmpty()) sb.append("1");
                    else sb.append("0");
                } else if (oper.equals("front")) {
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.peekFirst());
                } else if (oper.equals("back")) {
                    if (deque.isEmpty()) sb.append("-1");
                    else sb.append(deque.peekLast());
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
