package ProgrammersLevel2;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public String solution(int[] numbers) {
        String answer = "";
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {  // int to String
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        if (result[0].equals("0")) return "0";   // 0만 있는 경우

        for (String s : result) {
            answer += s;
        }

        return answer;
    }
}
