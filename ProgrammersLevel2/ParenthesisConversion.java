package ProgrammersLevel2;

public class ParenthesisConversion {
    public static void main(String[] args) {

    }

    public String solution(String p) {
        String answer = "";
        if (p.length() == 0) return answer;
        String u = "", v = "";
        int countL = 0, countR = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') countL++;
            else countR++;
            u += p.charAt(i);
            if (countL == countR) {
                if (i == p.length() - 1) v = "";
                else v = p.substring(i + 1);
                break;
            }
        }

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') countL++;
            else countR++;
            if(countR > countL) break;
        }

        if (countL == countR) {
            answer += u + solution(v);
        } else {
            answer += "(" + solution(v) + ")";
            u = u.substring(1, u.length()-1);
            for(int i=0;i<u.length();i++){
                if(u.charAt(i) == '(') answer += ")";
                else answer += "(";
            }
        }
        System.out.println("p: " + p + ", answer : " + answer);
        System.out.println();

        return answer;
    }
}
