package ProgrammersLevel2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            int h = i;
            int w = yellow / i;
            if ((w + 2) * (h + 2) - w * h == brown) {
                answer[0] = w + 2;
                answer[1] = h + 2;
                break;
            }
        }

        return answer;
    }
}
