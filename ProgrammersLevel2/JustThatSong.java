package ProgrammersLevel2;

public class JustThatSong {
    String[] sharp = {"C#", "D#", "E#", "F#", "G#", "A#"};
    String[] lowercase = {"c", "d", "e", "f", "g", "a"};

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int temp = 0;
        for (int i = 0; i < sharp.length; i++) {
            m = m.replaceAll(sharp[i], lowercase[i]);
        }

        for (String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            String[] startMusic = music[0].split(":");
            String[] endMusic = music[1].split(":");
            String musicName = music[2];
            String melody = music[3];
            for (int i = 0; i < sharp.length; i++) {
                melody = melody.replaceAll(sharp[i], lowercase[i]);
            }
            int melodyLength = melody.length();

            if (endMusic[0] == "00") endMusic[0] = "24";
            if (startMusic[0] == "00") startMusic[0] = "24";
            int runningTime = ((Integer.parseInt(endMusic[0]) - Integer.parseInt(startMusic[0])) * 60 +
                    Integer.parseInt(endMusic[1]) - Integer.parseInt(startMusic[1]));
            int codeIdx = 0;
            for (int i = melodyLength; i < runningTime; i++) {
                melody += melody.charAt(codeIdx);
                codeIdx = (codeIdx + 1) % melodyLength;

            }

            if (check(m, melody)) {
                if (temp < melodyLength) {
                    temp = melodyLength;
                    answer = musicName;
                }
            }
        }

        if (answer.equals("")) answer = "(None)";
        return answer;
    }

    public static boolean check(String m, String melody) {
        for (int i = 0; i < melody.length() - m.length(); i++) {
            if (melody.charAt(i) == m.charAt(0)) {
                for (int j = 1; j < m.length(); j++) {
                    if (melody.charAt(i + j) != m.charAt(j)) break;
                    if (j == m.length() - 1) {

                        return true;
                    }
                }
            }
        }
        return false;
    }
}
