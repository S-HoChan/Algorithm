package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q14612 {   // 김식당
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> orderList = new ArrayList<>(); // 테이블 번호, 주문 시간
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String ordered = st.nextToken();
            if (ordered.equals("sort")) {
                orderList.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] == o2[1]) return o1[0] - o2[0];
                        return o1[1] - o2[1];
                    }
                });
            } else if (ordered.equals("complete")) {
                int table = Integer.parseInt(st.nextToken());
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i)[0] == table) {
                        orderList.remove(i);
                        break;
                    }
                }
            } else { // order
                int table = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                orderList.add(new int[]{table, time});
            }

            if (orderList.isEmpty()) sb.append("sleep");
            else {
                for (int[] order : orderList) {   // print
                    sb.append(order[0]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
