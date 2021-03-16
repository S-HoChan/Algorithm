package ProgrammersLevel2;

public class JadenCase {
    public String solution(String s) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') answer += (char) (s.charAt(i) + 'A' - 'a');
                else answer += s.charAt(i);
            } else {
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') answer += (char) (s.charAt(i) + 'a' - 'A');
                else answer += s.charAt(i);
            }
        }

        return answer;
    }
}
