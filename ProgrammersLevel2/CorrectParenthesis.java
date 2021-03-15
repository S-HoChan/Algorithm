package ProgrammersLevel2;

public class CorrectParenthesis {
    boolean solution(String s) {
        boolean answer = true;

        int cntL = 0, cntR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cntR > cntL) return false;
            if (s.charAt(i) == '(') cntL++;
            else cntR++;
        }

        if (cntL != cntR) answer = false;

        return answer;
    }
}
