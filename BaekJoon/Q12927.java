package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12927 {   // 배수 스위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = br.readLine().toCharArray();
        boolean[] arr = new boolean[temp.length + 1];   // true : Y
        for (int i = 0; i < temp.length; i++) {
            arr[i + 1] = temp[i] == 'Y';
        }

        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]) {
                answer++;
                for (int j = i + i; j < arr.length; j += i) {
                    arr[j] = !arr[j];
                }
            }
        }
        System.out.println(answer);
    }
}
