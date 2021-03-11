package ProgrammersLevel2;

public class NumOf124 {
    public static void main(String[] args) {

    }

    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while (n > 0) {
            answer = numbers[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}
