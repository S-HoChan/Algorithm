package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {    // 로프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = 0;
        for(int i = n-1; i >= 0; i--){
            int temp = (n - i) * arr[i];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}
