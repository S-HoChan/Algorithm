package ProgrammersLevel2;

public class MaximumAndMinimum {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int min = Integer.parseInt(str[0]);
        int max = Integer.parseInt(str[0]);

        for (String num : str) {
            int temp = Integer.parseInt(num);
            min = min <= temp ? min : temp;
            max = max >= temp ? max : temp;
        }

        answer = min + " " + max;
        return answer;
    }
}
