package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3019 {    // 테트리스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] arr = new int[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        if (p == 1) {  // ㅣ, ㅡ 모양
            // ㅣ
            answer += c;
            // ㅡ
            for (int i = 0; i <= c - 4; i++) {
                if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2] && arr[i] == arr[i + 3]) answer++;
            }
        } else if (p == 2) {  // ㅁ 모양
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] == arr[i + 1]) answer++;
            }
        } else if (p == 3) {  // .:' 모양
            // .:'
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] == arr[i + 1] && arr[i] + 1 == arr[i + 2]) answer++;
            }
            // 90회전
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] - 1 == arr[i + 1]) answer++;
            }
        } else if (p == 4) {    // ':. 모양
            // ':.
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] == arr[i + 1] + 1 && arr[i + 1] == arr[i + 2]) answer++;
            }
            // 90회전
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] + 1 == arr[i + 1]) answer++;
            }
        } else if (p == 5) {    // ㅗ 모양
            // ㅗ
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) answer++;
            }
            // ㅓ
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] == arr[i + 1] + 1) answer++;
            }
            // ㅜ
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] == arr[i + 1] + 1 && arr[i] == arr[i + 2]) answer++;
            }
            // ㅏ
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] + 1 == arr[i + 1]) answer++;
            }
        } else if (p == 6) {    // ..: 모양
            // ..:
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) answer++;
            }
            // ㄱ
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] == arr[i + 1] + 2) answer++;
            }
            // :''
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] + 1 == arr[i + 1] && arr[i + 1] == arr[i + 2]) answer++;
            }
            // ㄴ
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] == arr[i + 1]) answer++;
            }
        } else {    // :.. 모양
            // :..
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) answer++;
            }
            // ┘
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] == arr[i + 1]) answer++;
            }
            // '':
            for (int i = 0; i <= c - 3; i++) {
                if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2] + 1) answer++;
            }
            // ┌
            for (int i = 0; i <= c - 2; i++) {
                if (arr[i] + 2 == arr[i + 1]) answer++;
            }
        }

        System.out.println(answer);
    }
}
