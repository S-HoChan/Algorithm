package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10774 {   // 저지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int j = Integer.parseInt(br.readLine());    // 저지의 수
        int a = Integer.parseInt(br.readLine());    // 선수의 수
        char[] jersey = new char[j];
        boolean[] checked = new boolean[j];
        for (int i = 0; i < j; i++) {
            jersey[i] = br.readLine().charAt(0);
        }
        for (int i = 0; i < a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char require = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken()) - 1;
            if (checked[num]) continue;
            if ((require == 'L' && jersey[num] == 'L') ||
                    (require == 'M' && (jersey[num] == 'M' || jersey[num] == 'L')) ||
                    (require == 'S')) {
                checked[num] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < j; i++) {
            if (checked[i]) answer++;
        }
        System.out.println(answer);
    }
}
