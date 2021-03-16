package ProgrammersLevel2;

import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering {
    public int solution(String str1, String str2) {
        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersect = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                set1.add(first + "" + second);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                set2.add(first + "" + second);
            }
        }

        Collections.sort(set1);
        Collections.sort(set2);

        for (String s : set1) {
            if (set2.remove(s)) intersect.add(s);
            union.add(s);
        }
        for (String s : set2) union.add(s);

        double answer = 0;
        if (union.size() == 0) answer = 0;
        else answer = (double) intersect.size() / (double) union.size();
        return (int) (answer * 65536);
    }
}
