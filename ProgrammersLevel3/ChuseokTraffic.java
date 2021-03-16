package ProgrammersLevel3;

public class ChuseokTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        double[] st = new double[lines.length];
        double[] et = new double[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String s = lines[i].split(" ")[1];
            String t = lines[i].split(" ")[2];
            int hh = Integer.parseInt(s.substring(0, 2));
            int mm = Integer.parseInt(s.substring(3, 5));
            double ss = Double.parseDouble(s.substring(6));
            double _time = Double.parseDouble(t.substring(0, t.length() - 1));

            double startTime = hh * 3600 + mm * 60 + ss - _time + 0.001;
            double endTime = hh * 3600 + mm * 60 + ss;
            st[i] = startTime;
            et[i] = endTime;
        }

        for (int i = 0; i < st.length; i++) {
            int cnt = 0;
            double startSection = st[i];
            double endSection = startSection + 1;
            for (int j = 0; j < st.length; j++) {
                double startTime = st[j];
                double endTime = et[j];
                if (startTime >= startSection && startTime < endSection) cnt++;
                else if (endTime >= startSection && endTime < endSection) cnt++;
                else if (startTime <= startSection && endTime > endSection) cnt++;
            }
            answer = Math.max(cnt, answer);

            cnt = 0;
            startSection = et[i];
            endSection = startSection + 1;
            for (int j = 0; j < st.length; j++) {
                double startTime = st[j];
                double endTime = et[j];
                if (startTime >= startSection && startTime < endSection) cnt++;
                else if (endTime >= startSection && endTime < endSection) cnt++;
                else if (startTime <= startSection && endTime > endSection) cnt++;
            }
            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
