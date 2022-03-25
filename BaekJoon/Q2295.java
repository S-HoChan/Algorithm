package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2295 {    // 세 수의 합
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        Collections.sort(list);

        for (int k = n - 1; k >= 0; k--) {
            for (int z = 0; z < k; z++) {
                if (isOk(arr[k] - arr[z])) {
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }

    static boolean isOk(int num) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > num) right = mid - 1;
            else if (list.get(mid) < num) left = mid + 1;
            else return true;
        }
        return false;
    }
}
