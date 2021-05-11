package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1427 {    // 소트인사이드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] nums = br.readLine().toCharArray();
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--)
            sb.append(nums[i]);

        System.out.println(sb);
    }
}
