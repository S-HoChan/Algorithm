package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20055 {   // 컨베이어 벨트 위의 로봇
    static int n, k;
    static int[] belt;
    static boolean[] onRobot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++)
            belt[i] = Integer.parseInt(st.nextToken());
        onRobot = new boolean[n];

        int answer = 0;
        while (isOk()) {
            answer++;

            // step 1
            int temp = belt[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
                if (i < n) onRobot[i] = onRobot[i - 1];
            }
            belt[0] = temp;
            onRobot[0] = false;

            onRobot[n - 1] = false; // 내리는 위치

            // step 2
            for (int i = n - 1; i > 0; i--) {
                if (onRobot[i - 1] && !onRobot[i] && belt[i] >= 1) {
                    onRobot[i - 1] = false;
                    onRobot[i] = true;
                    belt[i]--;
                }
            }

            // step 3
            if (belt[0] > 0) {
                onRobot[0] = true;
                belt[0]--;
            }
        }
        System.out.println(answer);
    }

    static boolean isOk() { // step 4
        int count = 0;
        for (int now : belt) {
            if (now == 0) count++;
            if (count >= k) return false;
        }
        return true;
    }
}
