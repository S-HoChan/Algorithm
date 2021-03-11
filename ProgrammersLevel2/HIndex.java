package ProgrammersLevel2;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {

    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        if(citations[citations.length-1] == 0) return 0;

        while (answer < citations.length) {
            if (citations[citations.length - answer - 1] <= answer) break;
            answer++;
        }

        return answer;
    }
}
