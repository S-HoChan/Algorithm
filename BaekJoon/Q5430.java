package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q5430 {    // AC
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String order = br.readLine();
            boolean isLeft = true;
            boolean isError = false;

            LinkedList<Integer> list = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());

            String numList = br.readLine();
            numList = numList.substring(1, numList.length() - 1);
            StringTokenizer st = new StringTokenizer(numList, ",");
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < order.length(); i++) {
                char now = order.charAt(i);
                if (now == 'R') {
                    isLeft = !isLeft;
                } else if (now == 'D') {
                    if (list.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isLeft) {
                        list.pollFirst();
                    } else {
                        list.pollLast();
                    }
                }
            }

            if (isError) {
                sb.append("error").append('\n');
            } else {
                sb.append('[');
                while (!list.isEmpty()) {
                    if (isLeft) sb.append(list.pollFirst());
                    else sb.append(list.pollLast());
                    if (!list.isEmpty()) sb.append(',');
                }
                sb.append(']').append('\n');
            }
        }

        System.out.println(sb);
    }
}
