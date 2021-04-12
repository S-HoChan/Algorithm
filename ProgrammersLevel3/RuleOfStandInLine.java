package ProgrammersLevel3;

import java.util.ArrayList;

public class RuleOfStandInLine {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i + 1);

        long num = k;   // 남은 개수
        for (int i = 1; i <= n; i++) {
            int remain = n - i;
            int j = 0;
            while (j < n) {
                if (num > factorial(remain)) {
                    num -= factorial(remain);
                    j++;
                } else break;
            }
            answer[i - 1] = list.get(j);
            list.remove(j);
        }

        return answer;
    }

    public long factorial(int n) {
        long result = 1;
        while (n > 1) {
            result *= n--;
        }
        return result;
    }
}
