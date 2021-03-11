package ProgrammersLevel2;

import java.util.*;

public class StockPrice {
    public static void main(String[] args) {

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int[] cnt = new int[prices.length]; // 1이면 증가, 0이면 정지
        for (int i = 0; i < prices.length - 1; i++) {
            if (stack.empty() || stack.peek() < prices[i]) {
                stack.push(prices[i]);
                cnt[i] = 1;
            } else {
                int idx = i;
                while (stack.peek() > prices[i]) {
                    stack.pop();
                    cnt[--idx] = 0;
                }
                stack.push(prices[i]);
                cnt[i] = 1;
            }

            for(int j = 0; j < answer.length; j++){ // count
                if (cnt[j] == 1) answer[j]++;
            }
        }

        return answer;
    }
}
