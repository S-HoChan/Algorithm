package ProgrammersLevel4;

public class NumberBlock {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        for (int i = 0; i < end - begin + 1; i++) {
            int cur = (int) begin + i;
            answer[i] = getGD(cur);
        }

        if (begin == 1) answer[0] = 0;
        return answer;
    }

    public int getGD(int cur){
        for (int i = 2; i <= Math.sqrt(cur); i++) {
            if (cur % i == 0 && (cur / i) < 10000000) {
                return cur / i;
            }
        }

        return 1;
    }
}
