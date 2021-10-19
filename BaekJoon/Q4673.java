package BaekJoon;

public class Q4673 {    // 셀프 넘버
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        boolean[] checked = new boolean[10001];
        for (int i = 1; i < 10001; i++) {
            if (checked[i]) continue;

            int next = i;
            while (true) {
                int now = next;
                while (now >= 1) {
                    next += now % 10;
                    now /= 10;
                }   // get next number
                if (next <= 10000) checked[next] = true;
                else break;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!checked[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}
