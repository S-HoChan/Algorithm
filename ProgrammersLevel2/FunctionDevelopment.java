package ProgrammersLevel2;

public class FunctionDevelopment {
    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer2 = new int[progresses.length];
        int pointer = 0;
        int idx = 0;

        while (pointer < progresses.length) {
            int ans = 0;
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] >= 0) progresses[i] += speeds[i];
            }   // operate
            while (progresses[pointer] >= 100) {
                ans++;
                progresses[pointer++] = -1;   // check
                if (pointer == progresses.length) break;
            }
            if (ans != 0) {
                answer2[idx++] = ans;
            }
        }

        int[] answer = new int[idx];
        for (int i = 0; i < idx; i++) {
            answer[i] = answer2[i];
        }

        return answer;
    }
}
