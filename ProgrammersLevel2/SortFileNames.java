package ProgrammersLevel2;

import java.util.Arrays;

public class SortFileNames {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] f = new File[files.length];
        int idx = 0;

        for (String file : files) {
            int i = 0;

            String head = "";
            while (i < file.length()) {
                if (!(file.charAt(i) >= '0' && file.charAt(i) <= '9')) {
                    head += file.charAt(i++);
                } else break;
            }   // HEAD

            String number = "";
            while (i < file.length()) {
                if (file.charAt(i) >= '0' && file.charAt(i) <= '9') {
                    number += file.charAt(i++);
                } else break;
            }   // NUMBER

            String tail = file.substring(i);    // TAIL

            f[idx++] = new File(head, number, tail);
        }

        Arrays.sort(f);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = f[i].fileHead + f[i].fileNumber + f[i].fileTail;
        }

        return answer;
    }

    public static class File implements Comparable<File> {
        String fileHead;
        String fileNumber;
        String fileTail;

        public File(String h, String n, String t) {
            fileHead = h;
            fileNumber = n;
            fileTail = t;
        }

        @Override
        public int compareTo(File f) {
            String fh1 = fileHead.toLowerCase();
            String fh2 = f.fileHead.toLowerCase();
            if (fh1.compareTo(fh2) != 0) return fh1.compareTo(fh2);

            int num1 = Integer.parseInt(fileNumber);
            int num2 = Integer.parseInt(f.fileNumber);
            return Integer.compare(num1, num2);
        }
    }
}
