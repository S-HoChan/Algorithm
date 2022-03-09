package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2513 {    // 통학버스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        PriorityQueue<Point> left = new PriorityQueue<>();
        PriorityQueue<Point> right = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int students = Integer.parseInt(st.nextToken());
            if (location < s) {
                left.add(new Point(s - location, students));
            } else if (location > s) {
                right.add(new Point(location - s, students));
            }
        }

        int answer = 0; // 거리만 계산 후 마지막에 X2
        int blank = 0;  // 빈자리
        while (!left.isEmpty()) {
            Point now = left.poll();
            while (now.students > 0) {    // 남은 학생이 있을 때
                if (blank == 0) {   // 빈 자리가 없다면 버스 새로 왕복
                    answer += now.distance;
                    blank = k;
                    continue;
                }

                if (now.students > blank) {
                    now.students -= blank;  // 타고 남은 학생 수
                    blank = 0;
                } else {
                    blank -= now.students;
                    now.students = 0;
                }
            }
        }

        blank = 0;
        while (!right.isEmpty()) {
            Point now = right.poll();
            while (now.students > 0) {
                if (blank == 0) {
                    answer += now.distance;
                    blank = k;
                    continue;
                }

                if (now.students > blank) {
                    now.students -= blank;
                    blank = 0;
                } else {
                    blank -= now.students;
                    now.students = 0;
                }
            }
        }

        System.out.println(answer * 2);
    }

    static class Point implements Comparable<Point> {
        int distance;
        int students;

        Point(int d, int s) {
            this.distance = d;
            this.students = s;
        }

        @Override
        public int compareTo(Point o) {
            return o.distance - distance;
        }   // 내림차순 정렬
    }
}
